import sort.InsertionSort

object Main extends App {
  val sequence = List(3, 5, 1)
  val insertionSort = new InsertionSort
  val sortedSequence = insertionSort.sort(sequence)
  sortedSequence.foreach(println(_))
}
