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

  test("No illegal characters") {
    intercept[IllegalArgumentException] {
      RomanNumeral("MCMAIV")
    }
  }

  test("Symbols must be in order") {
    intercept[IllegalArgumentException] {
      RomanNumeral("IM")
    }
  }

  test("Sequences must not be overlong") {
    intercept[IllegalArgumentException] {
      RomanNumeral("MMIIIII")
    }
  }

  test("Can extract a value from String") {
    val RomanNumeral(a: Int) = "MMCIV"
    assert(a === 2104)
  }

  test("Doesn't match nonsense strings") {
    intercept[scala.MatchError] {
      val RomanNumeral(a: Int) = "NOTROMAN"
      assert(a === a + 1) //Stop it complaining about unused val
    }
  }

  def assertConversion(arab: Int, romanString: String) {
    assert(RomanNumeral(arab).toString === romanString)
    assert(RomanNumeral(romanString).arab === arab)
  }

}
