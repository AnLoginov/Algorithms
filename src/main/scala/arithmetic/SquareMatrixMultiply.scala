package arithmetic

import scala.annotation.tailrec
import scala.language.postfixOps

/**
 * Assume two equal matrix of size n*n:
 *     |a11  a12|      |b11  b12|
 * A = |        |  B = |        |
 *     |a21  a22|,     |b21  b22|,
 *
 *              |a11*b11 + a12*b21  a11*b12 + a12*b22|
 * so C = A*B = |                                    |
 *              |a21*b11 + a22*b21  a21*b12 + a22*b22|.
 *
 * We can use algorithm with three cycles to count C:
 *
 * 1. for i = 0 to n - 1
 * 2.   for j = 0 to n - 1
 * 3.     C[ij] = 0
 * 4.     for k = 0 to n - 1
 * 5.       C[ij] = C[ij] + A[ik] * B[kj]
 * 6. return C;
 */
//TODO: currently the second matrix has to come inverted (so it is just a sequence of columns). Need to invert here.
class SquareMatrixMultiply extends Multiply[Array[Array[Int]]] {
  override def multiply(matrix1: Array[Array[Int]], matrix2: Array[Array[Int]]): Array[Array[Int]] = {
    countMatrix(matrix1.zipWithIndex, matrix2.zipWithIndex, new Array[Array[Int]](matrix1.length))
  }

  @tailrec
  private def countMatrix(rows: Array[(Array[Int], Int)], columns: Array[(Array[Int], Int)],
                          matrixAcc: Array[Array[Int]]): Array[Array[Int]] = {
    rows match {
      case r if r isEmpty => matrixAcc
      case r =>
        matrixAcc(r.head._2) = countRow(r.head._1, columns, new Array[Int](columns.length))
        countMatrix(r.tail, columns, matrixAcc)
    }
  }

  @tailrec
  private def countRow(row: Array[Int], columns: Array[(Array[Int], Int)], rowAcc: Array[Int]): Array[Int] = {
    columns match {
      case xs if xs isEmpty => rowAcc
      case xs =>
        rowAcc(xs.head._2) = countCell(row, xs.head._1)
        countRow(row, xs.tail, rowAcc)
    }
  }

  @tailrec
  private def countCell(row: Array[Int], column: Array[Int], cellAcc: Int = 0): Int = {
    (row, column) match {
      case (r, _) if r isEmpty => cellAcc
      case (r, c) => countCell(r.tail, c.tail, cellAcc = cellAcc + r.head * c.head)
    }
  }
}
