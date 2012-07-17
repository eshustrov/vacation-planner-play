import sbt._
import PlayProject._

object ApplicationBuild extends Build {
  val appName = "vacation-planner-play"
  val appVersion = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    "org.mockito" % "mockito-all" % "1.9.0"
  )

  val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
    // Add your own project settings here
  )
}
