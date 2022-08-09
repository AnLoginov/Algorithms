package sort

class InsertionSort {
  def sort(sequenceToSort: List[Int]): List[Int] = {
    if (sequenceToSort.isEmpty) Nil
    else insert(sequenceToSort.head, sort(sequenceToSort.tail))
  }
  def insert(value: Int, sortedList: List[Int]): List[Int] = {
    if (sortedList.isEmpty || (value <= sortedList.head)) value :: sortedList
    else sortedList.head :: insert(value, sortedList.tail)
  }
}
