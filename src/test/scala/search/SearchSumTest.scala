package search

import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import utils.TestBase

class SearchSumTest extends TestBase {
  val searchSum: SearchSum = new SearchSum

  test("search sum") {
    searchCases3.foreach(c => {
      searchSum.search(c.input, c.item) shouldEqual c.output
    })
  }

  val searchSumFast: SearchSumFast = new SearchSumFast

  test("search sum fast") {
    searchCases3.foreach(c => {
      searchSumFast.search(c.input, c.item) shouldEqual c.output
    })
  }
}
