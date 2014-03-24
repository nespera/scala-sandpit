import org.scalatest.FunSuite
import Percentage._

class PercentageTest extends FunSuite {

  test("Can increase a Percentage") {
    assert(new Percentage(120) +% 10 === 132)
  }

  test("Can increase a Double") {
    assert(100 +% 12 === 112)
  }
}
