package utils

import org.scalatest.funsuite.AnyFunSuite
import utils.TestBase.{SearchCase, SortCase}

class TestBase extends AnyFunSuite {
  val suite1 = List(3, 9, 1)
  val suite2 = List(10, 9, 5)
  val suite3 = List(0, -1, 12, 125, 4)

  protected val sortCases1 = Seq(
    SortCase(true, suite1, List(1, 3, 9)),
    SortCase(true, suite2, List(5, 9, 10)),
    SortCase(true, suite3, List(-1, 0, 4, 12, 125)),
    SortCase(false, suite1, List(9, 3, 1)),
    SortCase(false, suite2, List(10, 9, 5)),
    SortCase(false, suite3, List(125, 12, 4, 0, -1)))

  protected val searchCases1 = Seq(
    SearchCase(suite1, 9, Some(9)),
    SearchCase(suite1, 15, None),
    SearchCase(suite2, 0, None),
    SearchCase(suite2, 10, Some(10)),
    SearchCase(suite3, -1, Some(-1))
  )
}

object TestBase {
  case class SortCase(isAscending: Boolean, input: List[Int], output: List[Int])
  case class SearchCase(input: Seq[Int], item: Int, output: Option[_])
}