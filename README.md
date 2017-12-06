### About ###

A **very** thin Scala wrapper around Java `univocity-parsers` CSV parser.
Just to make usage more Scala friendly.

### Usage ###

```scala
import java.io.File
import com.igeolise.csv.Csv

val f = new File("data.csv")

Csv.readFile(f) { rows =>
  // rows is a Stream[Array[String]]
}
```
