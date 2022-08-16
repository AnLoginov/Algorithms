package sort

import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import utils.TestBase

class SelectionSortTest extends TestBase {
  val selectionSort: SelectionSort = new SelectionSort

  test("selection sort") {
    sortCases1.foreach(c => {
      selectionSort.sort(c.input, c.isAscending) shouldEqual c.output
    })
  }
}
