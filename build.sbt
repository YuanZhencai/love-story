name := "play-java-docker"

version := "1.0"

lazy val `play-java-docker` = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq( 
	javaJdbc , 
	javaEbean , 
	cache , 
	javaWs , 
	"com.typesafe.play" %% "play-mailer" % "2.4.1"
)

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  