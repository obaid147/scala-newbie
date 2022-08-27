import org.scalacheck.Gen
import org.scalatest.{FunSpec, Matchers}
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class PropertyDrivenTest extends FunSpec with Matchers with ScalaCheckPropertyChecks{
  /**
   * Scalatest has support for Scalacheck, which can generate random testing data: */

  describe("Property Checks") {
    they("should ensure absolute on all Ints returns a positive number") {
      forAll{
        (i: Int) =>
          whenever(i != Int.MinValue) {
            i.abs should be >= 0
          }
      }
    }
  }

  // Custom Property Generators
  val validChars = ('a' to 'z') ++ ('A' to 'Z') ++ ('0' to '9')

  val char = Gen.oneOf(validChars)

  val strGen = for{
    n <- Gen.choose(0, 30) // length of string
    seqChar <- Gen.listOfN(n, char)
  } yield seqChar.mkString
  println(strGen)

  describe("Property checks and generators") {
    they("should test .reverse.reverse on any string gives you back original") {
      strGen.map{ str =>
        println(str)
        str.reverse.reverse should be (str)
      }
    }

    it("should work on empty strings"){
      "".reverse should be ("")
    }
    it("should actually reverse a string"){
      "obaid".reverse should be("diabo")
    }
  }

}