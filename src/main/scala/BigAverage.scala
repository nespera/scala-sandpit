import scala.util.Random
import scala.actors.Actor._

object BigAverage {

  val SIZE: Int = 20000000
  val ACTORS: Int = 1000

  lazy val randomArray: Array[Int] = {
    val random = new Random()
    (for(i <- 1 to SIZE) yield random.nextInt(1001)).toArray
  }

  def average(array: Array[Int]) : Float = {

    def simpleAverage(a: Array[Int]) : Float = {
      a.map(_.toFloat).sum /  a.length
    }
    if (array.isEmpty) 0 else {

      val grouped = array.grouped(array.length/ACTORS)
      for (group <- grouped) {
        val ac = actor {
          receive {
            case x : Array[Int] => sender ! simpleAverage(x)
          }
        }
        ac ! group
      }
      var responses = 0
      var result: Float = 0
      while (responses < ACTORS) {
        receive {
          case f : Float =>
            result = result + f
            responses = responses + 1
        }
      }

      result/ACTORS
    }
  }
}
