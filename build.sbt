scalaVersion := "2.11.8"

organization := "com.igeolise"

name := "scala-csv-reader"

version := "0.1.0"

libraryDependencies ++= Seq(
  "com.univocity" %  "univocity-parsers" % "2.5.9",
  "commons-io"    %  "commons-io"        % "2.6",
  "org.scalatest" %% "scalatest"         % "3.0.4" % Test
)
