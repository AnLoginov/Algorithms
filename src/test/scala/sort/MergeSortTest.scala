package sort

import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import utils.TestBase

class MergeSortTest extends TestBase {
  val mergeSort: MergeSort = new MergeSort

  test("merge sort") {
    sortCases1.foreach(c => {
      mergeSort.sort(c.input, c.isAscending) shouldEqual c.output
    })
  }
}
