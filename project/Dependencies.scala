import sbt._

object Version {
//  val scalaVersion = "3.3.0-RC3"
  lazy val scalaVersion = "3.2.2"
  lazy val scalaTest = "3.2.14"
  lazy val scalaCheck = "3.2.9.0"
  lazy val sbtio = "1.7.0"
  lazy val typesafeConfig = "1.4.2"
  lazy val caseapp = "2.1.0-M21"
  lazy val cats = "2.8.0"
  lazy val devDirs = "26"
  lazy val github4s = "0.30.0"
  lazy val http4s = "0.23.6"
  lazy val circe = "0.14.1"
  lazy val circeConfig = "0.8.0"
}

object Library {
  lazy val scalaTest = "org.scalatest" %% "scalatest" % Version.scalaTest % Test
  lazy val scalaCheck = "org.scalatestplus" %% "scalacheck-1-15" % Version.scalaCheck % Test
  lazy val sbtio = "org.scala-sbt" %% "io" % Version.sbtio
  lazy val typesafeConfig = "com.typesafe" % "config" % Version.typesafeConfig
  lazy val commonsCodec = "commons-codec" % "commons-codec" % "1.15"
  lazy val caseapp = "com.github.alexarchambault" %% "case-app" % Version.caseapp
  lazy val cats = "org.typelevel" %% "cats-core" % Version.cats
  lazy val devDirs = ("dev.dirs" % "directories" % Version.devDirs).withJavadoc()

  lazy val http4s = Seq(
    "org.http4s" %% "http4s-dsl",
    "org.http4s" %% "http4s-blaze-server",
    "org.http4s" %% "http4s-blaze-client",
    "org.http4s" %% "http4s-circe"
  ).map(_ % Version.http4s)

  lazy val circe = "io.circe" %% "circe-generic" % Version.circe
  lazy val github4s = "com.47deg" %% "github4s" % Version.github4s
}

object Dependencies {

  import Library._

  lazy val cmtDependencies = List(sbtio, typesafeConfig, scalaTest, scalaCheck, commonsCodec, caseapp, cats).map(_.withSources())
  lazy val cmtcDependencies = (http4s ++ List(devDirs, circe, github4s)).map(_.withSources())
}
