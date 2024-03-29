import scala.language.implicitConversions

class Rational private (val n: Int, val d: Int) {
  require(d != 0, "Zero denominator!")
  println(s"R($n/$d)")
  override def toString: String = s"R($n/$d)"

def +(other: Rational): Rational =
  new Rational(
    this.n * other.d + this.d * other.n,
    this.d * other.d
  )
}
object Rational {
  def apply(n: Int, d: Int): Rational =
    new Rational(n, d)

 implicit def apply(i: Int): Rational =
  new Rational(i, 1)
}
val half = Rational(1, 2)
half + 5
Rational(5) + half
5 + half

/**
 * if apply has no implicit, type mismatch error.
 * warning @ line 16, import below to avoid warning
   import scala.language.implicitConversions
 */

class Person(val name: String){
  def checkName(other: Person): Boolean =
    this.name == other.name
}

val p1 = new Person("Obaid")
val p2 = new Person("abc")
p1.name
p2.name
p1 checkName p2
// p1 checkName "Obaid" // As it is expecting module10.Person obj
implicit def personToString(s: String): Person =
  new Person(s) /** converting person to string */

p1 checkName "Obaid"
p2 checkName "Obaid"