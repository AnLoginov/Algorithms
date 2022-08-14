package sort

import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import utils.TestBase

class InsertionSortTest extends TestBase {
  val insertionSort: InsertionSort = new InsertionSort

  test("insertion sort") {
    sortCases1.foreach(c => {
      insertionSort.sort(c.input, c.isAscending) shouldEqual c.output
    })
  }
}
