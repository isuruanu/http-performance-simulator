net.virtualvoid.sbt.graph.Plugin.graphSettings

name := "http-performance-simulator"

version := "1.0.0-SNAPSHOT"

organization := "auqa.http"

scalaVersion := "2.10.1"

scalaBinaryVersion := "2.10"

resolvers += "spray repo" at "http://repo.spray.io"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies += "io.spray" % "spray-client" % "1.1-M7" exclude("org.parboiled", "parboiled-scala_2.10.0-RC5")

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.1.4"

libraryDependencies += "io.spray" %%  "spray-json" % "1.2.5"

mainClass := Some("aqua.http.performance.Main")
