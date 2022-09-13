package search

import scala.annotation.tailrec

class MaxSubsequenceSearch extends Search[List[Int], (Int, Int)] {
  override def search(input: List[Int], item: (Int, Int) = (0, 0)): Option[_] = {
    input match {
      case Nil => None
      case _ => Some(divideAndConquer(input))
    }
  }

  private def divideAndConquer(sequence: List[Int]): (Int, Int) = {
    sequence match {
      case xs if xs.length == 1 => (xs.head, xs.head)
      case xs => {
        val mid = Math.floor(xs.length / 2).toInt
        val (left, right) = xs.splitAt(mid)
        val l = divideAndConquer(left)
        val r = divideAndConquer(right)
        val m = findMaxCrossingSubarray(left, right, (left.last, right.head))
        compareDiffAndGet(compareDiffAndGet(l, r), m)
      }
    }
  }

  private def findMaxCrossingSubarray(left: List[Int], right: List[Int], item: (Int, Int)): (Int, Int) = {
    (runOverLeft(left.init, (left.last, item._1))._1, runOverRight(right.tail, (item._2, right.head))._2)
  }

  @tailrec
  private def runOverLeft(input: List[Int], item: (Int, Int)): (Int, Int) = {
    input match {
      case Nil => item
      case _ :+ x =>
        if (x <= item._1) runOverLeft(input.init, (x, item._2))
        else runOverLeft(input.init, item)
    }
  }

  @tailrec
  private def runOverRight(input: List[Int], item: (Int, Int)): (Int, Int) = {
    input match {
      case Nil => item
      case x :: _ =>
        if (x >= item._2) runOverRight(input.tail, (item._1, x))
        else runOverRight(input.tail, item)
    }
  }

  private def compareDiffAndGet(item1: (Int, Int), item2: (Int, Int)): (Int, Int) = {
    if (Math.abs(item1._1 - item1._2) > Math.abs(item2._1- item2._2) && item1._1 < item1._2) item1
    else if (item2._1 < item2._2) item2
    else {
      if (Math.abs(item1._1 - item1._2) < Math.abs(item2._1- item2._2)) item1
      else item2
    }
  }
}
