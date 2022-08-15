import arithmetic.BitwiseSum

object Main extends App {
  val sequence1 = Array(0, 1, 1, 0)
  val sequence2 = Array(0, 1, 1, 2)
  val bitwiseSum = new BitwiseSum
  val res = bitwiseSum.sum(sequence1, sequence2)
  res.foreach(print(_))
}
