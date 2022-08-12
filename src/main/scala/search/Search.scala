package search

/**
 * Is a base trait for searching algorithms.
 * @tparam IN is a type of sequence, which is needed to scan for searching an item.
 * @tparam T is a type of item to search.
 * It returns either an item on type T or nothing.
 */
trait Search[IN, T] {
  def search(input: IN, item: T): Option[_]
}
