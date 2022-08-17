import arithmetic.BitwiseSum
import sort.{MergeSort, SelectionSort}

object Main extends App {
  val sequence1 = Array(0, 1, 1, 0)
  val sequence2 = List(0, 1, 1, 2, 5, 6, 2, -1)
  val mergeSort = new MergeSort
  val res = mergeSort.sort(sequence2, true)
  res.foreach(print(_))
}
