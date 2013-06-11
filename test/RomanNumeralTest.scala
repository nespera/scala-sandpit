import org.scalatest.FunSuite

class RomanNumeralTest extends FunSuite {

  test("Can construct from Int") {
    assert(RomanNumeral(1).arab === 1)
  }

  test("Must be positive") {
    intercept[IllegalArgumentException] {
      RomanNumeral(-1)
    }
    intercept[IllegalArgumentException] {
      RomanNumeral(0)
    }
  }

  test("One gives I") {
    assertAsRoman(1, "I")
  }

  test("Two gives II") {
    assertAsRoman(2, "II")
  }
  def assertAsRoman(arab: Int, romanString: String) {assert(RomanNumeral(arab).toString === romanString)}

}
