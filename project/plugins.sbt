libraryDependencies += "org.vafer" % "jdeb" % "1.3" artifacts (Artifact("jdeb", "jar", "jar"))
addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager"  % "1.2.0-M8")

// To run with the fix in https://github.com/sbt/sbt-native-packager/pull/938,
// comment out the sbt-native-packager line and uncomment these lines
// lazy val root = project.in( file(".") ).dependsOn( patchedSbtNativePackager )
// lazy val patchedSbtNativePackager = uri("git://github.com/ANorwell/sbt-native-packager#vary-fix")
