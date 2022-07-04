class Rational(val n: Int, val d: Int){
  require(d != 0, "Denominator is zero")
  override def toString: String = s"R($n/$d)"

//  def add(other: Rational): Rational = {
//    new Rational(
//      this.n * other.d + this.d * other.n,
//      this.d * other.d
//    )
//  }

  /**
   * Change add to + and infix does the rest
   * */

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

// val sum = half.+(fifth) re-written
/**
 * Scala doesn't have operator overloading, per-se
 * But it does have symbolic method names, (and operator precedence rules for first character)
 * operators ending with colan : are right associates.
 */