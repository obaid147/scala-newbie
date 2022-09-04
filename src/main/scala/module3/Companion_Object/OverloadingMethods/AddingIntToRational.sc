/**
 * Strategy two, overloading:
 */
class Rational private(val n: Int, val d: Int){
  require(d != 0, "Zero Denominator")
  override def toString: String =
    s"R($n/$d)"

  def +(other: Rational): Rational = {
  new Rational(
    this.n * other.d + this.d * other.n,
    this.d * other.d
  )
  }
  def +(i: Int): Rational = {
    println("-----------" ,this, Rational(i), i)
    this + Rational(i) // from companion
    // converting i to Rational
    // call + with other as Rational(i) which is 5, 1
  }
}

object Rational{
  def apply(n: Int, d: Int): Rational = new Rational(n, d)
  def apply(i: Int): Rational = new Rational(i, 1)
}

val half = Rational(1, 2)
val five = Rational(5) // wrapping 5 into rational

half + five // re-written half.+(five)
// OR
half + 5 // OR
Rational(1, 2) + 5 // re-written Rational(1,2).+(5)
/*First +(i: Int) gets called,
  That wraps 5 into Rational(i), and then that
  ends up calling +(n: INt, d: Int)
  this.+(Rational(i)) OR this + Rational(i)
 */

/**
 * No constructor accessible from here
 * val fifth = new Rational(1, 5)
 * val five = new Rational(5)
 * Need to remove new keyword
 * */
