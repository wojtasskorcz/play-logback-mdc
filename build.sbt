
name := "play-logback-mdc"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.3"

libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.7.2"
