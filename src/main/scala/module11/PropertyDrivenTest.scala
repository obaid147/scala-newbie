import org.scalacheck.Gen
import org.scalatest.{FunSpec, Matchers}

import scala.xml.Properties

class PropertyDrivenTest extends FunSpec with Matchers {
  val validChars = ('a' to 'z') ++ ('A' to 'Z') ++ (0 to 9)

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
  }

}