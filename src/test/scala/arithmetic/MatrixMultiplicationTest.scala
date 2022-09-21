package arithmetic

import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import utils.TestBase

class MatrixMultiplicationTest extends TestBase {
  val dumbMatrixMultiplication: SquareMatrixMultiply = new SquareMatrixMultiply

  test("Max subsequence search with element by element sequence processing") {
    matrixMultiplyCases.foreach(matrices => {
      dumbMatrixMultiplication.multiply(matrices.matrix1, matrices.matrix2) shouldEqual matrices.output
    })
  }
}
