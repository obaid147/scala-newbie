/**
 * It can access private behavior on the class
We can make the constructor private and use the factory methods only:

 */
class Rational private(val n: Int, val d: Int){
  require(d != 0, "Zero Denominator")

  override def toString: String = s"R($n/$d)"
}

object Rational{
  def apply(n: Int, d: Int): Rational =
    new Rational(n, d)

  def apply(i: Int): Rational =
    new Rational(i, 1)

}

val fifth = Rational(1, 5) // R(1/5)
val five = Rational(5)  // R(5/1)
/**
 * val half = new Rational(1, 2)
 * new keyword is not allowed! [private constructor]
 * Companion object can access private constructor
 * Whenever compiler sees that there is no new keyword, It looks for apply method inside companion object
 * re-written as:-
 * val fifth = Rational.apply(1, 5)
 * val five = Rational.apply(5)
 */