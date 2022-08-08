package sort

class InsertionSort {
  def insert[T](less: (T, T) => Boolean)(input: List[T], value: T): List[T] = {
    input.lastIndexOf(x => x < value)
  }
}
