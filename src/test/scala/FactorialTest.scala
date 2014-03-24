import org.scalatest.FunSuite
import Factorial._

class FactorialTest extends FunSuite {

  test("Can use bang operator") {
    assert((new Factorial(2)!) === 2)
  }

  test("Can use bang on integer") {
    assert((3!) === 6)
  }
}
