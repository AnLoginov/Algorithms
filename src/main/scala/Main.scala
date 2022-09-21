import arithmetic.{BitwiseSum, SquareMatrixMultiply}
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
  val matrix1 = Array(Array(-2, 1), Array(5, 4))
  val matrix2 = Array(Array(3, -1), Array(0, 0))
  val matrixMultiply = new SquareMatrixMultiply
  val res1 = matrixMultiply.multiply(matrix1, matrix2)
  res1.foreach(a1 => {a1.foreach(v => print(v + " ")); println()})
}
