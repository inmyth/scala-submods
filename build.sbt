
name := "scala-submods"

version := "0.1"

scalaVersion := "2.12.12"

lazy val appClass = "me.mbcu.submods.VertxWS"
mainClass in assembly := Some(appClass)
mainClass in (Compile, run) := Some(appClass)
mainClass in (Compile, packageBin) := Some(appClass)


libraryDependencies += "io.vertx" %% "vertx-lang-scala" % "3.5.4"
libraryDependencies += "io.vertx" %% "vertx-web-scala" % "3.9.1"
libraryDependencies += "io.monix" %% "monix" % "3.2.2+45-5c6c8b9e"
libraryDependencies += "io.monix" %% "monix-kafka-1x" % "1.0.0-RC6"
libraryDependencies += "org.apache.kafka" %% "kafka" % "2.6.0"
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3"

libraryDependencies += "com.pauldijou" %% "jwt-core" % "4.2.0"

assemblyMergeStrategy in assembly := {
  case PathList(ps @ _*) if ps.last endsWith ".html" => MergeStrategy.first
  case PathList("org", "slf4j", xs @ _*)             => MergeStrategy.first
  case PathList(ps @ _*) if ps.last endsWith ".properties" => MergeStrategy.first
  case PathList(ps @ _*) if ps.last endsWith ".xml" => MergeStrategy.first
  case PathList(ps @ _*) if ps.last endsWith ".types" => MergeStrategy.first
  case PathList(ps @ _*) if ps.last endsWith ".class" => MergeStrategy.first
  case PathList(ps @ _*) if ps.last endsWith ".txt" => MergeStrategy.first
  case "application.conf"                            => MergeStrategy.concat
  case "unwanted.txt"                                => MergeStrategy.discard
  case "BUILD"                                       => MergeStrategy.discard
  case PathList("META-INF", "MANIFEST.MF") => MergeStrategy.discard
  case PathList("META-INF", xs @ _*)                 => MergeStrategy.last
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}