import org.scalatest.{Matchers, FunSpec}

/**Matchers is a large DSL that makes tests easier to read (though possibly harder to write) */
class TestingMatchingDemo extends FunSpec with Matchers {

  describe("Various matchers") {
    describe("on a list of numbers") {
      val nums = (1 to 20).toList
      val threeMultiples = nums.filter(_ % 3 == 0)
      they("should allow a wide and varied language for matching") {
        val x = 10 * 2
        x should be(20)
        threeMultiples should have size 6
        threeMultiples should contain allOf(3, 6, 12, 15)
        threeMultiples should not contain 10
        threeMultiples should be(Vector(3, 6, 9, 12, 15, 18))
        threeMultiples should be(sorted)
        all(threeMultiples) should be > 0
        atLeast(3, threeMultiples) should be > 10
      }
    }
  }

  // Support for fields in case classes
  describe("on a case class example"){
    they("should allow easy field checking"){
      case class Person(name: String, age: Int)

      val p1 = Person("Obaid", 28)

      p1 should have(
        Symbol ("name") ("Obaid"),
        Symbol ("age")  (28)
      )
    }
  }

  // for checking exceptions
  describe("Handling exceptions"){
    it("should expect and intercept exceptions"){
      an [IllegalArgumentException] should be thrownBy{
        require(1 == 2, "One equals two?")
      }
      val ae = intercept[ArithmeticException](1/0)
//      ae.getMessage should be("/ by zero") // correct way
      ae.getMessage should be(" / by zero")
    }
  }

  //checking floating point values within tolerance
  describe("Floating point values"){
    they("should be matched within a tolerance"){
      val sqrt = math.sqrt(2.0)
      sqrt should be (1.41421356 +- 1e-6)
      sqrt should (be > 1.41421356 and be < 1e-6)
    }
  }
}