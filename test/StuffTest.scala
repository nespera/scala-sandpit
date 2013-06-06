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

  test("Empty string gives one") {
    assert(charProduct("") === 1)
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

  test("Two to power one is two") {
    assert(pow(2.0f, 1) === 2.0)
  }

  test("Something to power zero is one") {
    assert(pow(234.56f, 0) === 1.0)
  }

  test("Something to power one is itself") {
    assert(pow(8.2f, 1) === 8.2f)
  }

  test("Nine squared is 81") {
    assert(pow(9.0f, 2) === 81f)
  }

  test("Two cubed is 8") {
    assert(pow(2.0f, 3) === 8f)
  }

  test("4 to power -2 is 1/16") {
    assert(pow(4.0f, -2) === (1f/16))
  }

  test("arrayOf has right size and number range") {
    val size: Int = 10
    val array = arrayOf(size)
    assert(array.length === size)
    for (i <- array) {
      assert(i >=0 && i<size)
    }
  }

  test("flip array swaps elements of size 2 array") {
    assertFlip(Array(1, 2), Array(2, 1))
  }

  test("flip array ignores 3rd element") {
    assertFlip(Array(1,2,3), Array(2,1,3))
  }

  test("flip array ignores empty array") {
    assertFlip(Array(), Array())
  }

  def assertFlip(from: Array[Int], to: Array[Int]) {
    val a = from
    flipArray(a)
    assert(a === to)
  }
}
