name := "scala-submods"

version := "0.1"

scalaVersion := "2.12.12"



libraryDependencies += "io.vertx" %% "vertx-lang-scala" % "3.5.4"
libraryDependencies += "io.vertx" %% "vertx-web-scala" % "3.9.1"
libraryDependencies += "io.monix" %% "monix" % "3.2.2+45-5c6c8b9e"
libraryDependencies += "io.monix" %% "monix-kafka-1x" % "1.0.0-RC6"
libraryDependencies += "org.apache.kafka" %% "kafka" % "2.6.0"

libraryDependencies += "com.pauldijou" %% "jwt-core" % "4.2.0"