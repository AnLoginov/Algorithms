package search

import scala.annotation.tailrec

/**
 * This king of search is used for finding two items with maximum increasing difference within the sequence.
 * For example, if input is the sequence (-2, 3, 9, -7, 4, 8), algorithm must find a substring (-7, 4, 8)
 * and return its first and last items (-7, 8).
 * The approach, which is implemented below, has a quadratic time complexity, so is not optimal.
 * @return tuple of two item, such that the first one is less than the second one.
 */
class MaxSubsequenceElementwiseSearch extends Search[List[Int], (Int, Int)] {
  @tailrec
  final override def search(input: List[Int], item: (Int, Int) = (0, 0)): Option[_] = {
    input match {
      case Nil => None
      case xs if xs.length == 1 => Some(item)
      case x :: xs => search(xs, runOver(x, xs, item))
    }
  }

  @tailrec
  private def runOver(head: Int, seq: List[Int], item: (Int, Int)): (Int, Int) = {
    seq match {
      case Nil => item
      case x :: xs =>
        if (Math.abs(head - x) >= Math.abs(item._1 - item._2) && head < x) runOver(head, xs, (head, x))
        else runOver(head, xs, item)
    }
  }
}
