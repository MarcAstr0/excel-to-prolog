package com.marcastr0

object PrologWriter {

  def writeExplanation(name: String, vars: List[String]): String = {
    "% " + prologFriendly(name) + "(" + vars.mkString(",") + ")."
  }

  def writeFact(name: String, atoms: List[Any]): String = {
    val quotedStrings = atoms map {a => if (a.toString == "_" || isNumeric(a.toString)) a else "\"" + a + "\""}
    prologFriendly(name) + "(" + quotedStrings.mkString(",") + ")."
  }

  /**
    * Converts to a Prolog friendly camel-cased string and removes special characters
    * @param string
    */
  def prologFriendly(string: String): String = {
    val stringList = string.split(" ").toList
    (stringList.head ++ stringList.tail.map(_.capitalize)).mkString("")
  }

  def isNumeric(str: String): Boolean = {
    !throwsNumberFormatException(str.toLong) || !throwsNumberFormatException(str.toDouble)
  }

  def throwsNumberFormatException(f: => Any): Boolean = {
    try { f; false } catch { case e: NumberFormatException => true }
  }
}


