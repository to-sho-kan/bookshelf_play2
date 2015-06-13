import sbt._
import Keys._
import Tests._

/**
 * This is a simple sbt setup generating Slick code from the given
 * database before compiling the projects code.
 */
object myBuild extends Build {
  lazy val mainProject = Project(
    id="slick-codegen",
    base=file("."),
    settings = Project.defaultSettings ++ Seq(
      scalaVersion := "2.10.4",
      libraryDependencies ++= List(
        "com.typesafe.slick" %% "slick" % "2.1.0",
        "com.typesafe.slick" %% "slick-codegen" % "2.1.0",
        "org.slf4j" % "slf4j-nop" % "1.6.4",
        "mysql" % "mysql-connector-java" % "5.1.33"
      ),
      resolvers ++= Seq(
        "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/",
        "Typesafe Maven Repository" at "http://repo.typesafe.com/typesafe/maven-releases/"
      ),
      slick <<= slickCodeGenTask, // register manual sbt command
      sourceGenerators in Compile <+= slickCodeGenTask // register automatic code generation on every compile, remove for only manual use
    )
  )

  // code generation task
  lazy val slick = TaskKey[Seq[File]]("gen-tables")
  lazy val slickCodeGenTask = (sourceManaged, dependencyClasspath in Compile, runner in Compile, streams) map { (dir, cp, r, s) =>
    val outputDir = "../app"
    val url = "jdbc:mysql://localhost/to_sho_kan"
    val username = "root"
    val password = ""
    val jdbcDriver = "com.mysql.jdbc.Driver"
    val slickDriver = "scala.slick.driver.MySQLDriver"
    val pkg = "models"
    toError(r.run("scala.slick.codegen.SourceCodeGenerator", cp.files, Array(slickDriver, jdbcDriver, url, outputDir, pkg, username, password), s.log))
    val fname = outputDir + "/models/Tables.scala"
    Seq(file(fname))
  }
}