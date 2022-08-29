import arithmetic.BitwiseSum
import search.{SearchSum, SearchSumFast}
import sort.{MergeSort, SelectionSort}

object Main extends App {
  val sequence1 = Array(0, 1, 1, 0)
  val sequence2 = List(0, 1, 1, 2, 5, 6, 2, -1)
  val sequence3 = List(0, 1, 2, 5, 6)
  val mergeSort = new MergeSort
  val searchSum = new SearchSumFast
  val res = searchSum.search(sequence3, 7)
  println(res)
}
