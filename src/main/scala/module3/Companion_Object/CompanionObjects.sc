/**
class Rational(val n: Int, val d: Int){
  require(d != 0, "Denominator is zero")
  override def toString: String = s"R($n/$d)"

  def +(other: Rational): Rational = {
    new Rational(
      this.n * other.d + this.d * other.n,
      this.d * other.d
    )
  }
}
val half = new Rational(1, 2)
val fifth = new Rational(1, 5)
val sum = half + fifth
 */

class CompanionObjects(val n: Int, val d: Int){
  require(d != 0, "Zero Denominator")
  override def toString: String = s"R($n/$d)"

//  def this(i: Int) = this(i, 1)

  def +(other: CompanionObjects): CompanionObjects = {
    new CompanionObjects(
      this.n * other.d + this.d *  other.n,
      this.d * other.d
    )
  }
//  println(CompanionObjects.ObjectSecretCode)
}

object CompanionObjects{

//  private val ObjectSecretCode = s"This is a secret code"

  def apply(n: Int, d: Int): CompanionObjects = {
    new CompanionObjects(n, d)
  }

  def apply(i: Int): CompanionObjects = {
    new CompanionObjects(i, 10) // here d is 10 & i is 5
  }


}
// No need to use new keyword
CompanionObjects(1, 5)
CompanionObjects(5) // here i is 5 for line 41

CompanionObjects(1, 5) + CompanionObjects(5)