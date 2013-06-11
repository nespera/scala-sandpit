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

  test("Must be less than 5000") {
    intercept[IllegalArgumentException] {
      RomanNumeral(5000)
    }
  }

  test("One gives I") {
    assertAsRoman(1, "I")
  }

  test("Two gives II") {
    assertAsRoman(2, "II")
  }

  test("Five gives V") {
    assertAsRoman(5, "V")
  }

  test("Six gives VI") {
    assertAsRoman(6, "VI")
  }

  test("Ten gives X") {
    assertAsRoman(10, "X")
  }

  test("1650 gives MDCL") {
    assertAsRoman(1650, "MDCL")
  }

  test("1999 gives MCMXCIX") {
    assertAsRoman(1999, "MCMXCIX")
  }

  test("444 gives CDXLIV") {
    assertAsRoman(444, "CDXLIV")
  }

  def assertAsRoman(arab: Int, romanString: String) {assert(RomanNumeral(arab).toString === romanString)}

}
