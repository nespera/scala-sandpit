class RomanNumeral(val arab: Int) {
  require(arab > 0 && arab < 5000)

  override def toString: String = {
    RomanNumeral.stringify(arab)
  }
}

object RomanNumeral {
  val symbols = List("M" -> 1000, "D" -> 500, "C" -> 100, "L" -> 50, "X" -> 10, "V" -> 5, "I" -> 1)
  val symbolsPlusZero = symbols :+ "" -> 0

  private def nextSymbolFor(i: Int): (String, Int) = {
    symbolsPlusZero.filter(i >= _._2).head
  }

  private def stringify(i: Int): String = {
    contractSpecialCases(basicString(i))
  }

  private def basicString(i: Int): String = {
    val (symbol, value) = nextSymbolFor(i)
    symbol + (if (value > 0) basicString(i - value) else "")
  }

  //TODO refactor these two
  private def contractSpecialCases(romanString: String): String = {
    romanString.replace("DCCCC", "CM").replace("CCCC", "CD").replace("LXXXX", "XC")
               .replace("XXXX", "XL").replace("VIIII", "IX").replace("IIII", "IV")
  }

  private def expandSpecialCases(romanString: String): String = {
    romanString.replace("CM", "DCCCC").replace("CD", "CCCC").replace("XC", "LXXXX")
      .replace("XL", "XXXX").replace("IX", "VIIII").replace("IV", "IIII")
  }

  private def charToValue(c : Char): Int = {
    val matched = symbols.filter(_._1.head == c)
    if (matched.isEmpty) 0 else matched.head._2
  }

  private def parseString(roman: String): Int = {
    val basicString = expandSpecialCases(roman)
    basicString.foldLeft(0)((s, c) => s + charToValue(c))
  }

  def apply(arab: Int) = new RomanNumeral(arab)

  def apply(roman: String) = new RomanNumeral(parseString(roman))
}
