import org.scalatest.FunSuite
import BigAverage._

class BigAverageTest extends FunSuite {

  test("empty array gives zero") {
    assert(average(Array[Int]()) === 0)
  }

  test("small array test") {
    assert(average(Array(1,2,1,2,1,2,1,2,1,2)) === 1.5)
  }

  test("random array") {
    assert(randomArray.length === SIZE)
  }

  test("average random array") {
    assert(Math.round(average(randomArray)) === 500)
  }

}
