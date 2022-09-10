package search

import scala.annotation.tailrec

class MaxSubsequenceSearch extends Search[List[Int], (Int, Int)] {
  override def search(input: List[Int], item: (Int, Int) = (0, 0)): Option[_] = {
    input match {
      case Nil => None
      case xs if xs.length == 1 => x
    }
  }

  private def divideAndConquer(sequence: List[Int], item: (Int, Int)): List[Int] = {
    sequence match {
      case xs if xs.length == 1 => xs
      case 
    }
  }

  private def findMaxCrossingSubarray(left: List[Int], right: List[Int], item: (Int, Int)): (Int, Int) = {
    (runOverLeft(left, (item._1, item._1))._1, runOverRight(right, (item._2, item._2))._2)
  }

  @tailrec
  private def runOverLeft(input: List[Int], item: (Int, Int)): (Int, Int) = {
    input match {
      case Nil :+ _ => item
      case xs :+ x =>
        if (xs.last <= item._1) runOverLeft(xs.init, (xs.last, x))
        else runOverLeft(xs.init, item)
    }
  }

  @tailrec
  private def runOverRight(input: List[Int], item: (Int, Int)): (Int, Int) = {
    input match {
      case _ :: Nil => item
      case x :: xs =>
        if (xs.head >= item._2) runOverRight(xs.tail, (xs.head, x))
        else runOverRight(xs.tail, item)
    }
  }
}
