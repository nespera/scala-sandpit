
class Factorial(val value: Int) {
  def !() : Int = if (value < 1) 0 else if (value == 1) 1 else value * (new Factorial(value-1)!())
}

object Factorial {

  implicit def int2Factorial(value: Int) = new Factorial(value)
}