package sort

import scala.annotation.tailrec

class MergeSort extends Sort[List[Int]] {
  override def sort(data: List[Int], isAscendingOrder: Boolean): List[Int] = {
    data match {
      case Nil => Nil
      case xs :: Nil => List(xs)
      case _ => val (left, right) = data.splitAt(data.length / 2)
        if (isAscendingOrder)
          mergeAscending(sort(left, isAscendingOrder), sort(right, isAscendingOrder))
        else mergeDescending(sort(left,isAscendingOrder), sort(right, isAscendingOrder))
    }
  }

  @tailrec
  private def mergeAscending
  (subSeq1: List[Int], subSeq2: List[Int], acc: List[Int] = List()): List[Int] = {
    (subSeq1, subSeq2) match {
      case (Nil, _) => acc ++ subSeq2
      case (_, Nil) => acc ++ subSeq1
      case (x :: xs, y :: ys) =>
        if (x < y) mergeAscending(xs, subSeq2, acc :+ x)
        else mergeAscending(subSeq1, ys, acc :+ y)
    }
  }

  @tailrec
  private def mergeDescending
  (subSeq1: List[Int], subSeq2: List[Int], acc: List[Int] = List()): List[Int] = {
    (subSeq1, subSeq2) match {
      case (Nil, _) => acc ++ subSeq2
      case (_, Nil) => acc ++ subSeq1
      case (x :: xs, y :: ys) =>
        if (x > y) mergeDescending(xs, subSeq2, acc :+ x)
        else mergeDescending(subSeq1, ys, acc :+ y)
    }
  }
}
