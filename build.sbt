scalaVersion in ThisBuild := "2.11.8"

name := "sbt native packager example"

maintainer := "Arron Norwell"

version := "0.0.1"

enablePlugins(JDebPackaging)
enablePlugins(JavaServerAppPackaging)
enablePlugins(SystemdPlugin)
