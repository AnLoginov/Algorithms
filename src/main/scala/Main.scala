import arithmetic.BitwiseSum
import sort.SelectionSort

object Main extends App {
  val sequence1 = Array(0, 1, 1, 0)
  val sequence2 = List(0, 1, 1, 2, 5, 6, 2, -1)
  val selectionSort = new SelectionSort
  val res = selectionSort.sort(sequence2, true)
  res.foreach(print(_))
}
