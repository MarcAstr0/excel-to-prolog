package com.marcastr0

import org.scalatest.FlatSpec

class PrologWriterSpec extends FlatSpec {

  "writeFact" should "write a Prolog base clause or fact" in {
    assert(PrologWriter.writeFact("parent", List("david", "john")) == "parent(david, john).")
  }
}
