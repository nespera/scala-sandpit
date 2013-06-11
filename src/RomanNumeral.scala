class RomanNumeral(val arab: Int) {
  require(arab > 0 && arab < 5000)

  override def toString: String = {
    RomanNumeral.stringify(arab)
  }
}

object RomanNumeral {
  val symbols = List("M" -> 1000, "D" -> 500, "C" -> 100, "L" -> 50, "X" -> 10, "V" -> 5, "I" -> 1, "" -> 0)

  private def nextSymbolFor(i: Int): (String, Int) = {
    symbols.filter(symbol => i >= symbol._2).head
  }

  private def stringify(i: Int): String = {
    replaceSpecialCases(basicString(i))
  }

  private def basicString(i: Int): String = {
    val (symbol, value) = nextSymbolFor(i)
    symbol + (if (value > 0) basicString(i - value) else "")
  }

  def replaceSpecialCases(romanString: String): String = {
    romanString.replace("DCCCC", "CM").replace("CCCC", "CD").replace("LXXXX", "XC")
               .replace("XXXX", "XL").replace("VIIII", "IX").replace("IIII", "IV")
  }

  def apply(arab: Int) = new RomanNumeral(arab)
}
