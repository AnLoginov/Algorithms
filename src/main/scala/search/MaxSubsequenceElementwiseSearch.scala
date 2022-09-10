package search

import scala.annotation.tailrec

/**
 * This king of search is used for finding the maximum sum of two items within the sequence.
 * The approach, which is implemented below, has a quadratic time complexity, so is not optimal.
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
      case x :: xs => {
        if (Math.abs(head - x) >= Math.abs(item._1 - item._2)) runOver(head, xs, (head, x))
        else runOver(head, xs, item)
      }
    }
  }
}
