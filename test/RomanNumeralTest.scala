import org.scalatest.FunSuite

class RomanNumeralTest extends FunSuite {

  test("Can construct from Int") {
    assert(RomanNumeral(1).toString === "I")
  }

  test("Must be positive") {
    intercept[IllegalArgumentException] {
      RomanNumeral(-1)
    }
    intercept[IllegalArgumentException] {
      RomanNumeral(0)
    }
  }
}
