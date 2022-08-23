package search

import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import utils.TestBase

class BinarySearchTest extends TestBase {
  val binarySearch: BinarySearch = new BinarySearch

  test("linear search") {
    searchCases2.foreach(c => {
      binarySearch.search(c.input, c.item) shouldEqual c.output
    })
  }
}
