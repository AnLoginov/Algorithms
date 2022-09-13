import arithmetic.BitwiseSum
import search.{MaxSubsequenceElementwiseSearch, MaxSubsequenceSearch, SearchSum, SearchSumFast}
import sort.{BubbleSort, MergeInsertionSort, MergeSort, SelectionSort}

object Main extends App {
  val sequence1 = Array(0, 1, 1, 0)
  val sequence2 = List(0, 1, 1, 2, 5, 6, 2, -1)
  val sequence3 = List(0, 1, 2, 5, 6)
  val sequence4 = List(-2, 3, 9, -7, 4, 8)
  val mergeSort = new MergeSort
  val searchSum = new SearchSumFast
  val miSort = new MergeInsertionSort
  val bubbleSort = new BubbleSort
  val maxSubseqSearch = new MaxSubsequenceElementwiseSearch
  val maxSubseqSearch1 = new MaxSubsequenceSearch
  val res = maxSubseqSearch1.search(sequence4)
  println(res)
}
