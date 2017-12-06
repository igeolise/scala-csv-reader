[![Bintray Download](https://api.bintray.com/packages/igeolise/maven/scala-csv-reader/images/download.svg) ](https://bintray.com/igeolise/maven/scala-csv-reader/_latestVersion)

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

### SBT dependency ###
Package is available at [Bintray](https://bintray.com/igeolise/maven/scala-csv-reader).
Check for the latest version and add to your `build.sbt`:

```
resolvers += Resolver.bintrayRepo("igeolise", "maven")

libraryDependencies += "com.igeolise" %% "scala-csv-reader" % "<latest_version>"
```
