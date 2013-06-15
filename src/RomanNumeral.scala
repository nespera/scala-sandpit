class RomanNumeral(val arab: Int) {
  require(arab > 0 && arab < 5000)

  override def toString: String = {
    RomanNumeral.stringify(arab)
  }
}

object RomanNumeral {
  val symbols = List("M" -> 1000, "D" -> 500, "C" -> 100, "L" -> 50, "X" -> 10, "V" -> 5, "I" -> 1)
  val symbolsPlusZero = symbols :+ "" -> 0
  val specialCases = List("DCCCC" -> "CM", "CCCC" -> "CD", "LXXXX" -> "XC", "XXXX" -> "XL", "VIIII" -> "IX", "IIII" -> "IV")

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

  private def contractSpecialCases(romanString: String): String = {
    specialCases.foldLeft(romanString)((s, special) => s.replace(special._1, special._2))
  }

  private def expandSpecialCases(romanString: String): String = {
    specialCases.foldLeft(romanString)((s, special) => s.replace(special._2, special._1))
  }

  private def charToValue(c : Char): Int = {
    val matched = symbols.filter(_._1.head == c)
    require(!matched.isEmpty)
    matched.head._2
  }

  private def parseString(roman: String): Int = {
    val basicString = expandSpecialCases(roman)
    checkOrdering(basicString)
    checkForLongSequences(basicString)
    basicString.foldLeft(0)((s, c) => s + charToValue(c))
  }

  def checkForLongSequences(basicString: String) {
    for (symbol <- symbols) require(basicString.count(symbol._1.head == _) < 5)
  }

  def checkOrdering(basicString: String) {
    basicString.foldRight(0)((c, s) => {val v = charToValue(c); require(s <= v); v})
  }

  def apply(arab: Int) = new RomanNumeral(arab)

  def apply(roman: String) = new RomanNumeral(parseString(roman))
}
