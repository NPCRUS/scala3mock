lazy val root = project
  .in(file("."))
  .aggregate(scala3mock)

lazy val scala3mock = project.in(file("./scala3mock"))
  .settings(
    name := "scala3mock",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := "3.2.2",

    scalacOptions ++= Seq("-feature", "-explain"),

    // Useful when using the PrintAst[type] macro. That will provides the implementation
    // details of classes. Without it, only the signatures are available.
    // Test / scalacOptions += "-Yretain-trees", // For debugging when writing macros

    libraryDependencies += "org.scalameta" %% "munit" % "1.0.0-M7" % Test
  )
