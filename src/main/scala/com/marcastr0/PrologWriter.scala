package com.marcastr0

object PrologWriter {

  /**
    * Writes a commented Prolog clause with the predicate and the arguments for that clause
    * @param predicate the predicate name
    * @param arguments a list of argument names
    * @return
    */
  def writeExplanation(predicate: String, arguments: List[String]): String = {
    "% " + prologFriendly(predicate) + "(" + arguments.mkString(",") + ")."
  }

  /**
    * Writes a Prolog clause
    * @param predicate the predicate name
    * @param arguments a list of arguments
    * @return
    */
  def writeClause(predicate: String, arguments: List[Any]): String = {
    val quotedStrings = arguments map { a => if (a.toString == "_" || isNumeric(a.toString)) a else "\"" + a + "\""}
    prologFriendly(predicate) + "(" + quotedStrings.mkString(",") + ")."
  }

  /**
    * Converts to a Prolog friendly camel-cased string and removes special characters
    * @param string the string we want to convert
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


