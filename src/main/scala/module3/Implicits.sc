import language.implicitConversions

class Rational private(val n: Int, val d: Int){
  require(d != 0)

  override def toString: String = s"R($n/$d)"

  def +(other: Rational): Rational =
    new Rational(
      this.n * other.d + this.d * other.n,
      this.d * other.d
    )

}

object Rational{
  def apply(n: Int, d: Int) = new Rational(n, d)
  implicit def apply(i: Int) = new Rational(i, 1)
}

val half = Rational(1, 2)
half + 5