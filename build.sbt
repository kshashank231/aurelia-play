name := """Employee-morphia"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.3"

libraryDependencies ++= Seq(
  guice,
  "org.mongodb" % "mongodb-driver-sync" % "4.1.1"
)