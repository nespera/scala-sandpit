class RomanNumeral(val arab: Int) {
  require(arab > 0)
}
object RomanNumeral {
  def apply(arab: Int) = new RomanNumeral(arab)
}
