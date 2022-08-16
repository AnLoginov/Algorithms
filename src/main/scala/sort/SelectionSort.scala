package sort

import scala.annotation.tailrec

/**
 * Implementation of selection sort.
 */
class SelectionSort extends Sort[List[Int]] {
  override def sort(data: List[Int], isAscendingOrder: Boolean): List[Int] = {
    if (isAscendingOrder) {
      val min = data.min
      findAndPut(data.diff(Seq(min)), List(min), isAscendingOrder)
    } else {
      val max = data.max
      findAndPut(data.diff(Seq(max)), List(max), isAscendingOrder)
    }
  }

  @tailrec
  private def findAndPut(sequence: List[Int],
                         output: List[Int],
                         isAscending: Boolean): List[Int] = {
    if (sequence.isEmpty) output
    else {
      if (isAscending) {
        val min = sequence.min
        findAndPut(sequence.diff(Seq(min)), output :+ min, isAscending)
      } else {
        val max = sequence.max
        findAndPut(sequence.diff(Seq(max)), output :+ max, isAscending)
      }
    }
  }
}
