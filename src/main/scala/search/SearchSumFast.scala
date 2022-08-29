package search

import scala.annotation.tailrec

class SearchSumFast extends Search[Seq[Int], Int] {
  override def search(input: Seq[Int], item: Int): Option[_] = {
    divideAndConquer(input, item) match {
      case List(a, b) if a + b == item => Some((a, b))
      case _ => None
    }

  }

  private def divideAndConquer(input: Seq[Int], item: Int): List[Int] = {
    input match {
      case Nil => List()
      case Seq(a, b) if a + b == item => List(a, b)
      case xs :: Nil => List(xs)
      case _ => val (left, right) = input.splitAt(input.length / 2)
        sum(divideAndConquer(left, item) match {
          case List(a, b) if a + b == item => return List(a, b)
          case xs => xs
        }, divideAndConquer(right, item) match {
          case List(a, b) if a + b == item => return List(a, b)
          case xs => xs
        }, item)
    }
  }

  @tailrec
  private def sum(subSeq1: List[Int], subSeq2: List[Int], item: Int, acc: List[Int] = List()): List[Int] = {
    (subSeq1, subSeq2) match {
      case (x :: _, y :: _) if x + y == item => List(x, y)
      case (x :: Nil, Nil) => acc :+ x
      case (xs, y :: ys) => sum(xs, ys, item, acc :+ y)
      case (x :: xs, Nil) => sum(xs, acc, item, acc = List(x))
    }
  }
}
