name := "spray-workshop"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "io.spray" %% "spray-routing" % "1.3.3",
  "com.typesafe.akka" %% "akka-actor" % "2.3.11",
  "org.scalatest" %% "scalatest" % "2.2.4" % "test",
  "ch.qos.logback" % "logback-core" % "1.1.3"
)
