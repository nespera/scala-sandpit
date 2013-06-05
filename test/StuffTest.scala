import org.scalatest.FunSuite
import Stuff._

class StuffTest extends FunSuite {

  test("Positive number gives 1") {
    assert(signum(10) === 1)
  }

  test("Negative number gives -1") {
    assert(signum(-9) === -1)
  }

  test("Zero gives zero") {
    assert(signum(0) === 0)
  }

  test("Empty string gives zero") {
    assert(charProduct("") === 0)
  }

  test("A gives 65") {
    assert(charProduct("A") === 65)
  }

  test("AB gives 65*66") {
    assert(charProduct("AB") === 65*66)
  }

  test("Hello gives 9415087488") {
    assert(charProduct("Hello") === 9415087488L)
  }

}
