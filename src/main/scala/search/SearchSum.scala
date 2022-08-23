package search

import scala.annotation.tailrec

class SearchSum extends Search[Seq[Int], Int] {
  @tailrec
  final override def search(input: Seq[Int], item: Int): Option[_] = {
    sum(input, item) match {
      case None if input.length == 1 => None
      case Some((x, x1)) => Some((x, x1))
      case _ => search(input.tail, item)
    }
  }

  @tailrec
  final def sum(input: Seq[Int], item: Int): Option[_] = {
    input match {
      case _ :: xs if xs.isEmpty => None
      case s :: xs if s + xs.head == item => Some((s, xs.head))
      case s :: xs => sum(s :: xs.tail, item)
    }
  }
}
