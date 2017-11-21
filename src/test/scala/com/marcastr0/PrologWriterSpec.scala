package com.marcastr0

import org.scalatest.FlatSpec

class PrologWriterSpec extends FlatSpec {

  "writeExplanation" should "write a commented explanation of the following base clauses" in {
    assert(PrologWriter.writeExplanation("parent", List("parentName", "childName")) == "% parent(parentName,childName).")
  }

  "writeFact" should "write a Prolog base clause or fact" in {
    assert(PrologWriter.writeFact("parent", List("david", "john")) == "parent(david,john).")
  }

  "prologFriendly" should "convert a string to comply with Prolog conventions for predicates" in {
    assert(PrologWriter.prologFriendly("some predicate") == "somePredicate")
    assert(PrologWriter.prologFriendly("some other predicate") == "someOtherPredicate")
  }
}
