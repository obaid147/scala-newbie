// module3/Companion_Objects/OverloadingMethods
import scala.language.implicitConversions

class Rational private(val n: Int, val d: Int) { require(d != 0, "Zero denominator!")
  override def toString: String = s"R($n/$d)"
  def +(other: Rational): Rational =
    new Rational(
      this.n * other.d + this.d * other.n,
      this.d * other.d )

  //def this(i: Int) = new Rational(i, 1)
}

object Rational {

  def apply(n: Int, d: Int): Rational =
    new Rational(n, d)

  implicit def intToRational(i: Int): Rational = {
    Rational(i, 1)
  }
}


val ratioanl = Rational(1,2)

Rational(1, 2) + 3
// 3 + ratioanl
//3.+(ratioanl)
ratioanl.+(3)

3 + ratioanl


// implicits

//implicit def stringToInt(s: String): Int = s.toInt
//
//10 - "2"

/**
Scala compiler will see this unusual code on line 38, it was supposed to throw error
but there is one property of  scala compiler
  i.e scala compiler will check if there is
 any implicit conversion from string to int, if there is so, it will convert string
 to int and then execute this code otherwise it will throw the error
 */

class Person(val name: String) {
  def checkIfTwoPersonNamesAreSame(other: module10.Person): Boolean = {
    println(s"THIS:- ${this.name} and $this")
    println(s"OTHER:- ${other.name} and $other")
    this.name == other.name
  }
}

val person1 = new module10.Person("abc")
val person2 = new module10.Person("obaid")
person1 checkIfTwoPersonNamesAreSame person2

implicit def stringToPerson(s: String): module10.Person = new module10.Person(s)

//person1 checkIfTwoPersonNamesAreSame stringToPerson("obaid")
person2 checkIfTwoPersonNamesAreSame "obaid"
