package search

import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import utils.TestBase

class LinearSearchTest extends TestBase {
  val linearSearch: LinearSearch = new LinearSearch

  test("linear search") {
    searchCases1.foreach(c => {
      linearSearch.search(c.input, c.item) shouldEqual c.output
    })
  }
}
