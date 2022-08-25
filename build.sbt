name := "learning"

version := "0.1"

scalaVersion := "2.13.8"


libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8"
libraryDependencies += "org.scalamock" %% "scalamock" % "5.1.0"
libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.14.1"

val isAwesome = settingKey[Boolean]("some boolean setting")

isAwesome := true

val totally = settingKey[String]("rating of totalness of the statement")

totally := "100% totally"

val totallyAwesome = settingKey[String]("How awesome is this project")

totallyAwesome := totally.value +{
  println("Checking project awesomeness")
  if(isAwesome.value) "awesome" else "not awesome"
}

val checkAwesome = taskKey[Unit]("check project awesomeness")
checkAwesome := {
  val _ = (compile in Test).value // force test:compile task
  println("Project is " + totallyAwesome.value)
}