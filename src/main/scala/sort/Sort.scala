package sort
/**
 Is a base trait for sorting algorithms. It defines main method "sort".
 @tparam IN is a type of sequence to sort.
 The method returns a sequence of same type and length as input.
 */
trait Sort[IN] {
  def sort(data: IN, isAscendingOrder: Boolean): IN
}
