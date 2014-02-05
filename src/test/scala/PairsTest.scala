import org.scalatest.FunSuite

class PairsTest extends FunSuite {

  test("Can swap values of immutable pair") {
    val pair = new ImmutablePair("oxo", 9)
    assert(pair.first === "oxo")
    assert(pair.second === 9)
    val swap = pair.swap
    assert(swap.first === pair.second)
    assert(swap.second === pair.first)
  }

  test("Can swap values of mutable pair") {
    val pair = new MutablePair("oxo", "eye")
    assert(pair.first === "oxo")
    assert(pair.second === "eye")
    pair.swap()
    assert(pair.first === "eye")
    assert(pair.second === "oxo")
  }

  test("Can do a swap with a generic method") {
    val swap = Pairs.swap(new ImmutablePair("hej", true))
    assert(swap.first === true)
    assert(swap.second === "hej")
  }

  test("Can swap chalk and cheese if they are the same") {
    val cnc = new ChalkAndCheese("brie", "edam")
    cnc.swap()
    assert(cnc.first === "edam")
    assert(cnc.second === "brie")
  }

  test("Middle returns middle element") {
    assert(Pairs.middle("world") === 'r')
    assert(Pairs.middle(List(0,1,2,4)) === 1)
    assert(Pairs.middle(List("a")) === "a")
  }
}
