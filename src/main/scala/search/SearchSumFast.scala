package search

class SearchSumFast extends Search[Seq[Int], Int] {
  override def search(input: Seq[Int], item: Int): Option[_] = {

  }

  private def sum(subSeq1: List[Int], subSeq2: List[Int], item: Int, acc: List[Int] = List()): Option[_] = {
    (subSeq1, subSeq2) match {
      case (x :: _, y :: _) if x + y == item => Some((x, y))
      case (x :: xs, y :: ys) =>
        sum(xs, y :: ys, item, acc :+ x)
        sum(x :: xs, ys, item, acc :+ x)
    }
  }
}
