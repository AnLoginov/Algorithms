package sort

import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import utils.TestBase

class MergeInsertionSortTest extends TestBase {
  val mergeInsertionSort = new MergeInsertionSort

  test("merge insertion sort") {
    sortCases1.foreach(c => {
      mergeInsertionSort.sort(c.input, c.isAscending) shouldEqual c.output
    })
  }
}
