import org.scalatest.FunSuite
import scala.actors.Actor._

class ActorTest extends FunSuite {

  test("two ones is two") {

    val doubler = actor {
        receive {
          case x: Int =>
            sender ! x * 2
        }
    }
    Thread.sleep(5000)
    val result = doubler !? 1
    assert(result === 2)

  }
}
