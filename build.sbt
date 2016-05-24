import sbt.Project.projectToRef
import com.typesafe.sbt.less.Import.LessKeys

javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-Xlint")

initialize := {
  val _ = initialize.value
  if (sys.props("java.specification.version") != "1.8")
    sys.error("Java 8 is required for this project.")
}

lazy val clients = Seq(client)
lazy val scalaV = "2.11.8"

dependencyOverrides += "org.scala-lang" % "scala-library" % scalaVersion.value


lazy val server = (project in file("server")).settings(
  scalaVersion := scalaV,
  scalaJSProjects := clients,
  pipelineStages := Seq(scalaJSProd, gzip),
  resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases",
  libraryDependencies ++= Seq(
    "com.vmunier" %% "play-scalajs-scripts" % "0.5.0",
    "org.webjars" % "jquery" % "1.11.1",
    "org.webjars" % "angularjs" % "1.5.5",
    specs2 % Test
  ),
  // Heroku specific
  herokuAppName in Compile := "your-heroku-app-name",
  herokuSkipSubProjects in Compile := false,
  includeFilter in (Assets, LessKeys.less) := "*main.less"
).enablePlugins(PlayScala).
  aggregate(clients.map(projectToRef): _*).
  dependsOn(sharedJvm)

lazy val client = (project in file("client")).settings(
  scalaVersion := scalaV,
  persistLauncher := true,
  persistLauncher in Test := false,
  libraryDependencies ++= Seq(
    "org.scala-js" %%% "scalajs-dom" % "0.8.0",
    "biz.enef" %%% "scalajs-angulate" % "0.2.4",
    "be.doeraene" %%% "scalajs-jquery" % "0.9.0"
  )
).enablePlugins(ScalaJSPlugin, ScalaJSPlay).
  dependsOn(sharedJs)

lazy val shared = (crossProject.crossType(CrossType.Pure) in file("shared")).
  settings(
  	scalaVersion := scalaV,
  	libraryDependencies ++= Seq(
      "com.lihaoyi" %%% "fastparse" % "0.3.7",
      "com.lihaoyi" %%% "scalatags" % "0.5.3"

    )
  ).
  jsConfigure(_ enablePlugins ScalaJSPlay)

lazy val sharedJvm = shared.jvm
lazy val sharedJs = shared.js

// loads the Play project at sbt startup
onLoad in Global := (Command.process("project server", _: State)) compose (onLoad in Global).value

// for Eclipse users
EclipseKeys.skipParents in ThisBuild := false
// Compile the project before generating Eclipse files, so that generated .scala or .class files for views and routes are present
EclipseKeys.preTasks := Seq(compile in (server, Compile))

