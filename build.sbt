name := "First Assignment"

version := "0.1"

scalaVersion := "2.12.12"
lazy val common=(project in file("common"))

  .settings(
    name:= "Common module",
    libraryDependencies ++=Seq(
      "org.json4s" %% "json4s-native" % "4.0.3",
      "org.slf4j" % "slf4j-api" % "2.0.0-alpha2",
      "puppetlabs" % "typesafe-config" % "0.2.0",
      "org.typelevel" %% "discipline-scalatest" % "2.1.5" % Test,
      "org.mockito" %% "mockito-scala" % "1.16.46" % Test))

lazy val Persistence =(project in file("Persistence"))

  .settings(
    name:= "Persistence module",
    libraryDependencies ++=Seq(
      "com.typesafe.slick" %% "slick" % "3.3.3",
      "org.postgresql" % "postgresql" % "42.3.1",
      "com.h2database" % "h2" % "1.4.200" % Test

    )).dependsOn(common)

lazy val root = (project in file(".")).aggregate(Persistence,common)