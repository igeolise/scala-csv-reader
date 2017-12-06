package com.igeolise

import java.util

import com.igeolise.csv.Csv.Row
import org.scalactic.{CanEqual, Equality, Equivalence}

package object csv {

  implicit val streamRowCanEqual = new CanEqual[Stream[Row], Stream[Row]] {
    override def areEqual(a: Stream[Row], b: Stream[Row]) = {
      util.Arrays.deepEquals(a.toArray, b.toArray)
    }
  }
}
