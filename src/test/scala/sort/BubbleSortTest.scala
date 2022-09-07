package sort

import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import utils.TestBase

class BubbleSortTest extends TestBase {
  val bubbleSort: BubbleSort = new BubbleSort

  test("bubble sort") {
    sortCases1.foreach(c => {
      bubbleSort.sort(c.input, c.isAscending) shouldEqual c.output
    })
  }
}
