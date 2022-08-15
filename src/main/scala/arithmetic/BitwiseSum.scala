package arithmetic

import scala.annotation.tailrec

/**
 * Is a summarizer, which is used for calculation sum of two bitwise numbers,
 * represented by arrays of 1 and 0. Current implementation processes only
 * numbers of same length.
 * input: A = B = <0, 1, ..., n-1>
 * 1. j = n - 1, temp = 0, C = <0, 1, ..., n>
 * 2. while j >= 0
 * 3.   if (A[j] XOR B[j] XOR temp == 1) C[j + 1] = 1 else C[j + 1] = 0
 * 4.   if ((A[j] & B[j] & temp == 1) || (A[j] XOR B[j] XOR temp == 0))
 *        temp = 1
 *      else temp = 0
 * 5.   j--
 * output: C = A + B
 */
class BitwiseSum extends Sum[Array[Int]] {
  /**
   * Base method of the summarizer.
   * @param value1 is a first bitwise number.
   * @param value2 is a second bitwise number.
   * @return result a bitwise sum operation over two values.
   */
  override def sum(value1: Array[Int], value2: Array[Int]): Array[Int] = {
    processBits(List.empty, 0 +: value1, 0 +: value2, 0).toArray
  }

  @tailrec
  private def processBits(output: List[Int],
                          value1: Array[Int],
                          value2: Array[Int],
                          reminder: Int): List[Int] = {
    if (value1.isEmpty) output
    else processBits(putToOutput(output, value1.last ^ value2.last ^ reminder),
      value1.init, value2.init, takeReminder(value1.last, value2.last, reminder))
  }

  private def takeReminder(bit1: Int, bit2: Int, reminder: Int): Int = {
    assert(bit1 == 1 || bit1 == 0)
    assert(bit2 == 1 || bit2 == 0)
    if (((bit1 & bit2 & reminder) == 1) || ((bit1 ^ bit2 ^ reminder) == 0)) 1
    else 0
  }

  private def putToOutput(output: List[Int], bitProcessingResult: Int): List[Int] = {
    if (output.isEmpty) List(bitProcessingResult)
    else bitProcessingResult :: output
  }
}
