package com.marcastr0

object PrologWriter {

  def writeExplanation(name: String, vars: List[String]): String = {
    "% " + name + "(" + vars.mkString(",") + ")."
  }

  def writeFact(name: String, atoms: List[Any]): String = {
    name + "(" + atoms.mkString(",") + ")."
  }
}
