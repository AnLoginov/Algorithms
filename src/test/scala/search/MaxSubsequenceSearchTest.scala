package search

import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import utils.TestBase

class MaxSubsequenceSearchTest extends TestBase {
  val elementwiseSearch: MaxSubsequenceElementwiseSearch = new MaxSubsequenceElementwiseSearch

  test("Max subsequence search with element by element sequence processing") {
    searchCases4.foreach(sequence => {
      elementwiseSearch.search(sequence.input) shouldEqual sequence.output
    })
  }

  val divideAndConquerSearch: MaxSubsequenceSearch = new MaxSubsequenceSearch

  test("Max subsequence search in divide and conquer way") {
    searchCases4.foreach(sequence => {
      divideAndConquerSearch.search(sequence.input) shouldEqual sequence.output
    })
  }
}
