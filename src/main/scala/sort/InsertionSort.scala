package sort

class InsertionSort {
  def sort(sequenceToSort: List[Int], isAscending: Boolean): List[Int] = {
    if (sequenceToSort.isEmpty) Nil
    else insert(sequenceToSort.head, sort(sequenceToSort.tail, isAscending), isAscending)
  }
  def insert(value: Int, sortedList: List[Int], isAscending: Boolean): List[Int] = {
    if (sortedList.isEmpty) value :: sortedList
    else if (isAscending) {
      if (value <= sortedList.head) value :: sortedList
      else sortedList.head :: insert(value, sortedList.tail, isAscending)
    } else {
      if (value > sortedList.head) value :: sortedList
      else sortedList.head :: insert(value, sortedList.tail, isAscending)
    }
  }
}
