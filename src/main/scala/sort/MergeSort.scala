package sort

import scala.annotation.tailrec

class MergeSort extends Sort[List[Int]] {
  override def sort(data: List[Int], isAscendingOrder: Boolean): List[Int] = {
      if (isAscendingOrder) mergeAscending(List(), divide(data, Seq()))
      else mergeDescending(List(), divide(data, Seq()))
  }

  @tailrec
  private def divide(sequence: List[Int], dividedSequence: Seq[List[Int]]): Seq[List[Int]] = {
    if (sequence.isEmpty) dividedSequence
    else if (sequence.length == 1) divide(sequence, dividedSequence :+ sequence)
    else divide(sequence, dividedSequence)
  }

  @tailrec
  private def mergeAscending(output: List[Int], divideFunction: Seq[List[Int]]): List[Int] = {
    if (divideFunction.length == 1) output ::: divideFunction.head
    else if (divideFunction.isEmpty) output
    else mergeAscending(mergeAscending(
      divideFunction.head, divideFunction.tail.head, output), divideFunction.drop(2))
  }

  @tailrec
  private def mergeDescending(output: List[Int], divideFunction: Seq[List[Int]]): List[Int] = {
    if (divideFunction.length == 1) output ::: divideFunction.head
    else if (divideFunction.isEmpty) output
    else mergeDescending(mergeDescending(
      divideFunction.head, divideFunction.tail.head, output), divideFunction.drop(2))
  }

  @tailrec
  private def mergeAscending(subSeq1: List[Int], subSeq2: List[Int], output: List[Int]): List[Int] = {
    if (subSeq1.isEmpty && subSeq2.isEmpty) output
    else {
      if (subSeq1.isEmpty || subSeq1.head >= subSeq2.head)
        mergeAscending(subSeq1, subSeq2.tail, output :+ subSeq2.head)
      else mergeAscending(subSeq1.tail, subSeq2, output :+ subSeq1.head)
    }
  }

  @tailrec
  private def mergeDescending(subSeq1: List[Int], subSeq2: List[Int], output: List[Int]): List[Int] = {
    if (subSeq1.isEmpty && subSeq2.isEmpty) output
    else {
      if (subSeq1.isEmpty || subSeq1.head >= subSeq2.head)
        mergeDescending(subSeq1, subSeq2.tail, output :+ subSeq2.head)
      else mergeDescending(subSeq1.tail, subSeq2, output :+ subSeq1.head)
    }
  }
}
