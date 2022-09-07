package sort

import scala.annotation.tailrec

class BubbleSort extends Sort[List[Int]] {
  override def sort(data: List[Int], isAscendingOrder: Boolean): List[Int] = {
    data match {
      case Nil => Nil
      case _ => moveLeft(data,isAscendingOrder)
    }
  }

  @tailrec
  private def moveLeft(sequence: List[Int], isAscendingOrder: Boolean, acc: List[Int] = List()): List[Int] = {
    sequence match {
      case x :: Nil => x :: acc
      case xs =>
        val temp = if (isAscendingOrder) {
          runOverAscending(xs)
        } else {
          runOverDescending(xs)
        }
        moveLeft(temp.init, isAscendingOrder, temp.last :: acc)
    }
  }

  @tailrec
  private def runOverAscending(sequence: List[Int], acc: List[Int] = List()): List[Int] = {
    sequence match {
      case x :: Nil => acc :+ x
      case x :: xs => {
        if (x > xs.head) runOverAscending(x :: xs.tail, acc :+ xs.head)
        else runOverAscending(xs, acc :+ x)
      }
    }
  }

  @tailrec
  private def runOverDescending(sequence: List[Int], acc: List[Int] = List()): List[Int] = {
    sequence match {
      case x :: Nil => acc :+ x
      case x :: xs => {
        if (x < xs.head) runOverDescending(x :: xs.tail, acc :+ xs.head)
        else runOverDescending(xs, acc :+ x)
      }
    }
  }
}
