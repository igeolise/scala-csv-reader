package com.igeolise.csv

import java.io._

import com.univocity.parsers.csv.{CsvParser, CsvParserSettings}
import org.apache.commons.io.input.BOMInputStream

object Csv {
  type Row = Array[String]

  def readInputStream[T](input: InputStream)(f: Stream[Row] => T): T = {
    val parser = new CsvParser(new CsvParserSettings())

    // XXX: resources will be automatically closed at the end of input,
    //      no need to manually close the parser later.
    parser.beginParsing(new BOMInputStream(input))

    def loop: Stream[Row] = {
      val row = parser.parseNext()
      if(row == null) {
        Stream.empty
      } else {
        replaceNullsMutable(row) #:: loop
      }
    }

    f(loop)
  }

  def readFile[T](file: File)(f: Stream[Row] => T): T = readInputStream(new FileInputStream(file))(f)

  def readString[T](str: String)(f: Stream[Row] => T): T = readInputStream(new ByteArrayInputStream(str.getBytes))(f)

  /*
   * XXX: Mutable for performance.
   */
  private def replaceNullsMutable(row: Row): Row = {
    row.indices.foreach { i =>
      val v = row(i)
      if(v == null) row(i) = ""
    }
    row
  }
}
