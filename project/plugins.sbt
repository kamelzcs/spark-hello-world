//could go to ~/.sbt/1.0/global.sbt
resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.9")
addSbtPlugin("com.artima.supersafe" % "sbtplugin" % "1.1.7")
