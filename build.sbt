organization := "com.thoughtworks"

name := "unfiltered-workshop"

val unusedWarnings = (
  "-Ywarn-unused" ::
  "-Ywarn-unused-import" ::
  Nil
)

scalacOptions ++= PartialFunction.condOpt(CrossVersion.partialVersion(scalaVersion.value)){
  case Some((2, v)) if v >= 11 => unusedWarnings
}.toList.flatten

Seq(Compile, Test).flatMap(c =>
  scalacOptions in (c, console) --= unusedWarnings
)

scalacOptions ++= "-deprecation" :: "unchecked" :: "-feature" :: Nil

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.12.4"

val unfilteredVersion = "0.9.1"

libraryDependencies ++= Seq(
   "ws.unfiltered" %% "unfiltered-netty-server" % unfilteredVersion,
   "ws.unfiltered" %% "unfiltered-directives" % "0.9.1",
   "org.slf4j" % "slf4j-nop" % "1.7.10",
   "org.scalacheck" %% "scalacheck" % "1.13.4" % "test",
   "org.specs2" %% "specs2-scalacheck" % "3.9.5" % "test"
)
