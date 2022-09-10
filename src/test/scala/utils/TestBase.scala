package utils

import org.scalatest.funsuite.AnyFunSuite
import utils.TestBase.{BitwiseSumCase, SearchByConditionCase, SearchCase, SortCase}

class TestBase extends AnyFunSuite {
  val suite1 = List(3, 9, 1)
  val suite2 = List(10, 9, 5)
  val suite3 = List(0, -1, 12, 125, 4)

  // bitwise operations suits
  val suite4: Array[Int] = Array(1, 1, 1, 1)
  val suite5: Array[Int] = Array(0, 1, 1, 0)
  val suite6: Array[Int] = Array(0, 0, 0, 0)
  val suite7: Array[Int] = Array(0, 1, 0, 1)

  // sorted sequences
  val suite8 = List(0, 3, 7, 9, 14, 15, 28, 47)
  val suite9 = List(-1, 6, 12, 25, 33)

  val suite10 = List(5, 7, 0, 13, -14, 2, 8, -3, 19, -7, 70)
  val suite11 = List(0, -2, 3, 12, -5, 8, 11)

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

  protected val bitwiseSumCases = Seq(
    BitwiseSumCase(suite4, suite5, Array(1, 0, 1, 0, 1)),
    BitwiseSumCase(suite4, suite6, Array(0, 1, 1, 1, 1)),
    BitwiseSumCase(suite5, suite7, Array(0, 1, 0, 1, 1)),
    BitwiseSumCase(suite7, suite4, Array(1, 0, 1, 0, 0))
  )

  protected val searchCases2 = Seq(
    SearchCase(suite8, 28, Some(28)),
    SearchCase(suite8, 0, Some(0)),
    SearchCase(suite8, 9, Some(9)),
    SearchCase(suite8, 4, None),
    SearchCase(suite9, 12, Some(12)),
    SearchCase(suite9, 33, Some(33))
  )

  protected val searchCases3 = Seq(
    SearchCase(suite1, 4, Some((3, 1))),
    SearchCase(suite1, 5, None),
    SearchCase(suite3, 3, Some((-1, 4))),
    SearchCase(suite8, 9, Some((0, 9)))
  )

  protected val searchCases4 = Seq(
    SearchByConditionCase(suite8, Some(0, 47)),
    SearchByConditionCase(suite3, Some(-1, 125)),
    SearchByConditionCase(suite10, Some(-14, 70)),
    SearchByConditionCase(suite11, Some(-5, 11))
  )
}

object TestBase {
  case class SortCase(isAscending: Boolean, input: List[Int], output: List[Int])
  case class SearchCase(input: Seq[Int], item: Int, output: Option[_])
  case class BitwiseSumCase(value1: Array[Int], value2: Array[Int], output: Array[Int])
  case class SearchByConditionCase(input: List[Int], output: Option[_])
}