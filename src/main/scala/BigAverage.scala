import scala.util.Random

object BigAverage {

  val SIZE: Int = 20000000

  def randomArray: Array[Int] = {
    val random = new Random()
    (for(i <- 1 to SIZE) yield random.nextInt(1001)).toArray
  }

  def average(array: Array[Int]) : Float = {

    def smallAve[T](a: Array[T])(implicit numeric: Numeric[T]) : Float = {
      a.map(numeric.toFloat).sum /  a.length
    }
    if (array.isEmpty) 0 else {
      val grouped = array.grouped(array.length/10)
      smallAve(grouped.map(smallAve(_)).toArray)
    }
  }
}
