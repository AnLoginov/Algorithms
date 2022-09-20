package arithmetic

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
class SquareMatrixMultiply extends Multiply[Array[Array[Int]]] {
  override def multiply(value1: Array[Array[Int]], value2: Array[Array[Int]],
                        acc: Array[Array[Int]] = Array[Array[Int]](Array())): Array[Array[Int]] = {
    value1.zipWithIndex match {
      case xs if xs isEmpty => acc
      case xs => {
        value2.zipWithIndex match {
          case ys if ys isEmpty => acc
          case ys =>
            acc(xs.head._2(ys.head._2))
            multiply(value1.tail, value2.tail, )
        }
      }
    }
  }

  private def iter(row: (Array[Int], Int), column: (Array[Int], Int), rowAcc: Array[Int] = Array()): Array[Int] = {

  }
}
