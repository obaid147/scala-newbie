import org.scalatest.{FunSuite, Matchers, FunSpec}
// --------------- FunSuit
class TestingSuiteDemo extends FunSuite with Matchers{
  val numbers: List[Int] = (1 to 20).toList

  test("Filtering a list"){
    val filtered =  numbers.filter(_ > 15)
    assert(filtered == List(16, 17, 18, 19,20))
    // filtered should be (List(16, 17, 18, 19,20))
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

// FunSpec ----------------------
class TestingSpecDemo extends FunSpec {
  describe ("Retrieving the weather from the weather service") {
    it ("should call getWeather only if operational is true")(pending)
    it ("should not call getWeather if service not operational")(pending)
    it ("should not call getWeather if operational throws an exception")(pending)
    it ("should call getWeather with different codes when necessary")(pending)
  }
  describe ("Various matchers") {
    describe("on a list of numbers") {
      they("should allow a wide and varied language for matching")(pending)
    }
    describe("on a case class example") {
      they("should allow easy field checking")(pending)
    }
  }
  describe ("Handling exceptions") {
    it ("should expect and intercept exceptions")(pending)
  }
}