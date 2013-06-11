class RomanNumeral(val arab: Int) {
  require(arab > 0)

  override def toString: String = {
    RomanNumeral.stringify(arab)
  }
}

object RomanNumeral {
  val symbols = List("X" -> 10, "V" -> 5, "I" -> 1, "" -> 0)

  private def nextSymbolFor(i: Int): (String, Int) = {
    symbols.filter(symbol => i >= symbol._2).head
  }

  private def stringify(i: Int): String = {
    val (symbol, value) = nextSymbolFor(i)
    symbol + (if (value > 0) stringify(i - value) else "")

  }
  def apply(arab: Int) = new RomanNumeral(arab)
}
