import org.scalatest.FunSuite

class RomanNumeralTest extends FunSuite {

  test("Can construct from Int") {
    assert(RomanNumeral(1).arab === 1)
  }

  test("Can construct from String") {
    assert(RomanNumeral("I").arab === 1)
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
    assertConversion(1, "I")
  }

  test("Two gives II") {
    assertConversion(2, "II")
  }

  test("Five gives V") {
    assertConversion(5, "V")
  }

  test("Six gives VI") {
    assertConversion(6, "VI")
  }

  test("Ten gives X") {
    assertConversion(10, "X")
  }

  test("1650 gives MDCL") {
    assertConversion(1650, "MDCL")
  }

  test("1999 gives MCMXCIX") {
    assertConversion(1999, "MCMXCIX")
  }

  test("444 gives CDXLIV") {
    assertConversion(444, "CDXLIV")
  }

  //TODO test for non roman characters
  //TODO test for out of order characters
  //TODO test for over long sequences

  def assertConversion(arab: Int, romanString: String) {
    assert(RomanNumeral(arab).toString === romanString)
    assert(RomanNumeral(romanString).arab === arab)
  }

}
