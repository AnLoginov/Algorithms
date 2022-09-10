import arithmetic.BitwiseSum
import search.{MaxSubsequenceElementwiseSearch, SearchSum, SearchSumFast}
import sort.{BubbleSort, MergeInsertionSort, MergeSort, SelectionSort}

object Main extends App {
  val sequence1 = Array(0, 1, 1, 0)
  val sequence2 = List(0, 1, 1, 2, 5, 6, 2, -1)
  val sequence3 = List(0, 1, 2, 5, 6)
  val mergeSort = new MergeSort
  val searchSum = new SearchSumFast
  val miSort = new MergeInsertionSort
  val bubbleSort = new BubbleSort
  val maxSubseqSearch = new MaxSubsequenceElementwiseSearch
  val res = maxSubseqSearch.search(sequence2)
  println(res)
}
