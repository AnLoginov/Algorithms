package arithmetic

import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import utils.TestBase

class BitwiseSumTest extends TestBase {
  val bitwiseSum: BitwiseSum = new BitwiseSum

  test("insertion sort") {
    bitwiseSumCases.foreach(c => {
      bitwiseSum.sum(c.value1, c.value2) shouldEqual c.output
    })
  }
}
