package com.igeolise.csv

import org.scalactic.TripleEqualsSupport
import org.scalatest.{FunSpec, Matchers}

class CsvSpec extends FunSpec with Matchers with TripleEqualsSupport {

  it("should skip empty lines") {
    val csv =
      """
        |
        |a,b
        |
        |c,d
        |
      """.stripMargin

    Csv.readString(csv) { lines =>
      lines should === (Stream(Array("a", "b"), Array("c", "d")))
    }
  }

  it("should handle unclosed quotes") {
    // By "handle" does not mean that it magically fixes the quotes,
    // but rather does not throw exceptions and continues with following lines.
    val csv =
      """
        |"a","b"
        |c","d"
        |"e,"f"
        |g,h
      """.stripMargin

    Csv.readString(csv) { lines =>
      lines should === (Stream(
        Array("a", "b"),
        Array("c\"", "d"),
        Array("\"e,\"f\""),
        Array("g", "h")
      ))
    }
  }

  it("should truncate strings") {
    val csv =
      """
        |a , b
        | c ,  d
      """.stripMargin

    Csv.readString(csv) { lines =>
      lines should === (Stream(
        Array("a", "b"),
        Array("c", "d")
      ))
    }
  }

  it("should return empty strings") {
    val csv =
      """
        |,
        | ,
      """.stripMargin

    Csv.readString(csv) { lines =>
      lines should === (Stream(
        Array("", ""),
        Array("", "")
      ))
    }
  }

}
