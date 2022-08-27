import module10.Person
//import cats.implicits.catsKernelStdOrderForInt

//import scala.io.BufferedSource
//
//val eqInt = Eq[Int]
//
//import cats.instances.int._
//eqInt.eqv(11, 11)

//val l: List[String] = scala.io.Source.fromFile("").getLines().toList , performance kill
//val l: Iterator[String] = scala.io.Source.fromFile("").getLines().toList

/*for(line <- l) {
  println(line)
}

def method: List[Long] = {
  (1L to 1000000000L).toList
}
//method

(1 to 10).toList

// private[this] , object private access
// a method who does the boolean check is called predicate

class Rational(val n: Int, val d: Int) {
  require(d != 0, "Zero denominator!")
  override def toString: String = s"R($n/$d)"
  // rational addition
  def add(other: Rational): Rational = {
    val newNumerator = ((this.n * other.d) + (this.d * other.n))
    val newDenominator = this.d * other.d
    val nO = new Rational(newNumerator, newDenominator)
        val newRational = new Rational(
      this.n * other.d + this.d * other.n,
      this.d * other.d )
      newRational
  }
    nO
  }
}
val r1 = new Rational(1, 2)
val r2 = new Rational(3, 4)
r1 add r2
*/
//1 / 2 (this) + 3 / 4 (that) ==> (1 * 4 + 2 * 3) / 2 * 4

/**
 * Auxiliary constructor must delegate to the primary constructor
 */

class Person(name: String, age: Int, address: String) {

  def this(name: String, age: Int) = {
    this(name, age, "srinagar")
  }

  def this(name: String) = {
    this(name, 10)
  }
}
new module10.Person("aamir", 33, "bangalore") // Primary Constructor
new Person("obaid", 22) // auxiliary constructor with 2 defined parameters
new Person("shehzal") // auxiliary constructor with 1 defined parameter

// -------------------------------------------------------------------------------------------
//singleton ---- singleton object
object LL {
  val name = "NAME"
}


LL.name