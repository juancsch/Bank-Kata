/** ********* PROJECT INFO *****************/
scalaVersion := "2.12.4"

name := "BankKata"
organization := "es.juanc.katas.bankkata"
version := "0.0.1"

/** ********* DEPENDENCIES *****************/
libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.4" % Test,
  "org.scalamock" %% "scalamock" % "4.1.0" % Test
)

/** ********* COMMANDS ALIASES ******************/
addCommandAlias("t", "test")
addCommandAlias("c", "compile")
addCommandAlias("tc", "test:compile")
