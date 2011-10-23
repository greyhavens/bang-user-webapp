import sbt._
import Keys._
import com.github.siasia.WebPlugin.webSettings
import net.thunderklaus.GwtPlugin._

object BangUserWebappBuild extends Build {
  val extSettings = Defaults.defaultSettings ++ webSettings ++ gwtSettings

  val user = Project(
    "user", file("."), settings = extSettings ++ Seq(
      organization     := "com.threerings",
      name             := "banguser-webapp",
      version          := "1.0-SNAPSHOT",
      scalaVersion     := "2.9.0-1",
      scalacOptions    ++= Seq("-unchecked", "-deprecation"),
      crossPaths       := false,

      gwtVersion       := "2.4.0",
      javacOptions     ++= Seq("-Xlint", "-Xlint:-serial"),

      // give GWT some memory juices
      javaOptions in Gwt ++= Seq("-mx512M"),

      resolvers ++= Seq(
        "Local Maven Repository" at Path.userHome.asURL + "/.m2/repository"
      ),

      autoScalaLibrary := true, // GWT plugin turns this off
      libraryDependencies ++= Seq(
        "com.threerings" % "user-webapp" % "1.0-SNAPSHOT",
        // we only need these for the GWT build, so we use "provided"
        "com.threerings" % "gwt-utils" % "1.6-SNAPSHOT" % "provided"
      )
    )
  )
}
