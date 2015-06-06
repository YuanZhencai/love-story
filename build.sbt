name := "play-java-docker"

version := "1.0"

lazy val `play-java-docker` = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq( 
	javaJdbc , 
	javaEbean , 
	cache , 
	javaWs ,
	"com.google.inject" % "guice" % "3.0",
	"javax.inject" % "javax.inject" % "1",
	"com.typesafe.play" %% "play-mailer" % "2.4.1",
	"commons-httpclient" % "commons-httpclient" % "3.1",
	"org.apache.httpcomponents" % "httpclient" % "4.4"
)

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  