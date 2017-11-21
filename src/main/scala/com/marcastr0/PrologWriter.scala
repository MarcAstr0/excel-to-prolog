package com.marcastr0

object PrologWriter {

  def writeExplanation(name: String, vars: List[String]): String = {
    "% " + prologFriendly(name) + "(" + vars.mkString(",") + ")."
  }

  def writeFact(name: String, atoms: List[Any]): String = {
    prologFriendly(name) + "(" + atoms.mkString(",") + ")."
  }

  /**
    * Converts to a Prolog friendly camel-cased string and removes special characters
    * @param string
    */
  def prologFriendly(string: String): String = {
    val stringList = string.split(" ").toList
    (stringList.head ++ stringList.tail.map(_.capitalize)).mkString("")
  }
}
