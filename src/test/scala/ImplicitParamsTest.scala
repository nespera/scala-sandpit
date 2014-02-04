import org.scalatest.FunSuite
import ImplicitParams._

class ImplicitParamsTest extends FunSuite {

  test("can supply param") {
    assert(repeat("hey")(new Repetition(2)) === "heyhey")
  }

  test("can supply magic param") {
    implicit val repeater = new Repetition(3)
    assert(repeat("ho") === "hohoho")
  }

}
