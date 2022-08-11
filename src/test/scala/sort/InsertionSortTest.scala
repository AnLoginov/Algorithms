package sort

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

class InsertionSortTest extends AnyFunSuite {
  val insertionSort: InsertionSort = new InsertionSort
  val suite1 = List(3, 9, 1)
  val suite2 = List(10, 9, 5)
  val suite3 = List(0, -1, 12, 125, 4)

  private val cases = Seq(
    Case(true, suite1, List(1, 3, 9)),
    Case(true, suite2, List(5, 9, 10)),
    Case(true, suite3, List(-1, 0, 4, 12, 125)),
    Case(false, suite1, List(9, 3, 1)),
    Case(false, suite2, List(10, 9, 5)),
    Case(false, suite3, List(125, 12, 4, 0, -1)))

  test("insertion sort") {
    cases.foreach(c => {
      insertionSort shouldEqual c.output
    })
  }

  case class Case(isAscending: Boolean, input: List[Int], output: List[Int])

}
