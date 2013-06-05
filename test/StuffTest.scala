import org.scalatest.FunSuite
import Stuff._

class StuffTest extends FunSuite {

  test("positive number gives 1") {
    assert(signum(10) == 1)
  }

  test("negative number gives -1") {
    assert(signum(-9) == -1)
  }

  test("zero gives zero") {
    assert(signum(0) == 0)
  }

}
