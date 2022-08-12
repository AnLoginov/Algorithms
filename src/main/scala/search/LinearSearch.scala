package search

class LinearSearch {
  def search(input: Seq[Int], item: Int): Option[_] = {
    input.find(i => i.equals(item))
  }
}
