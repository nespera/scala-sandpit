
class Repetition(val count: Int)

object ImplicitParams {

  def repeat(thingy : String)(implicit printCount: Repetition) = {
    thingy * printCount.count
  }

  def withRepetition(count: Int)(f: => Unit) = {
    implicit val repeat = new Repetition(count)
    f
  }
}
