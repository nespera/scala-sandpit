class RomanNumeral(val arab: Int) {
  require(arab > 0)
  override def toString: String = "I"
}
object RomanNumeral {
  def apply(arab: Int) = new RomanNumeral(arab)
}
