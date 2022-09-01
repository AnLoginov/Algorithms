package sort

class MergeInsertionSort extends Sort[List[Int]] {
  override def sort(data: List[Int], isAscendingOrder: Boolean): List[Int] = {
    val insertionSort = new InsertionSort
    val k = Math.log(data.length)
    data match {
      case Nil => Nil
      case xs if xs.length == k => xs
      case _ => val (left, right) = data.splitAt(data.length / 2)
        if (isAscendingOrder) mergeAscending(
          insertionSort.sort(left, isAscendingOrder), insertionSort.sort(right, isAscendingOrder))
        else mergeDescending(
          insertionSort.sort(left, isAscendingOrder), insertionSort.sort(right, isAscendingOrder))
    }
  }

  def mergeAscending(subSeq1: List[Int], subSeq2: List[Int], acc: List[Int] = List()): List[Int] = {
    (subSeq1, subSeq2) match {
      case (xs, Nil) => acc ++ xs
      case (Nil, ys) => acc ++ ys
      case (x :: xs, y :: _) if x < y => mergeAscending(xs, subSeq2, acc :+ x)
      case (_, y :: ys) => mergeAscending(subSeq1, ys, acc :+ y)
    }
  }

  def mergeDescending(subSeq1: List[Int], subSeq2: List[Int], acc: List[Int] = List()): List[Int] = {
    (subSeq1, subSeq2) match {
      case (xs, Nil) => acc ++ xs
      case (Nil, ys) => acc ++ ys
      case (x :: xs, y :: _) if x > y => mergeDescending(xs, subSeq2, acc :+ x)
      case (_, y :: ys) => mergeDescending(subSeq1, ys, acc :+ y)
    }
  }
}
