package search

import scala.annotation.tailrec

class BinarySearch extends Search[Seq[Int], Int] {
  @tailrec
  final override def search(input: Seq[Int], item: Int): Option[_] = {
    val (left, right) = input.splitAt(input.length / 2)
    if (right.head == item) return Some(item)
    if (item > right.head && right.tail.isEmpty || item < right.head && left.isEmpty) None
    else {
      if (item > right.head) search(right.tail, item)
      else search(left, item)
    }
  }
}
