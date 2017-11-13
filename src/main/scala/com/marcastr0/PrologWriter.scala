package com.marcastr0

object PrologWriter {

  def writeFact(name: String, atoms: List[Any]): String = {
    name + atoms.foldLeft("")((a, b) => a + ", " + b) + "."
  }
}
