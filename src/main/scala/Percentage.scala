
class Percentage(val value: Double) {

  def +%(percent: Int) : Double = {
    value + (value * percent / 100)
  }
}

object Percentage {

  implicit def double2percentage(value: Double) = new Percentage(value)

}
