package com.marcastr0

import org.scalatest.FlatSpec

class PrologWriterSpec extends FlatSpec {

  "writeExplanation" should "write a commented explanation of the following base clauses" in {
    assert(PrologWriter.writeExplanation("parent", List("parentName", "childName")) == "% parent(parentName,childName).")
  }

  "writeClause" should "write a Prolog base clause or fact" in {
    assert(PrologWriter.writeClause("parent", List("david", "john")) == "parent(\"david\",\"john\").")
    assert(PrologWriter.writeClause("parent", List("david", "_")) == "parent(\"david\",_).")
    assert(PrologWriter.writeClause("some predicate", List("david", "_", 1.0)) == "somePredicate(\"david\",_,1.0).")
  }

  "prologFriendly" should "convert a string to comply with Prolog conventions for predicates" in {
    assert(PrologWriter.prologFriendly("some predicate") == "somePredicate")
    assert(PrologWriter.prologFriendly("some other predicate") == "someOtherPredicate")
  }
}
