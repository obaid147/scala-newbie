import org.scalatest.{FunSuite, Matchers}

class TestingSuiteDemo extends FunSuite with Matchers{
  val numbers: List[Int] = (1 to 5).toList

  test("Filtering a list"){
    val filtered =  numbers.filter(_ > 15)
    assert(filtered == Seq(16, 17, 18, 19,20))
  }

  test("Summing a list"){
    numbers.sum should be (210)
  }

  test("Try something else")(pending)
}

/**tests all have a string name, names must be unique in that suite.
 * First test uses assert with === (this is not the elidable{omitted while speaking}
    pre-condition assert).
 * Second test uses Matchers for more readability, should be.
 * The pending test at the end will put out a warning until defined */