class Rational(val n: Int, val d: Int){
  require(d != 0, "Denominator is Zero")
  override def toString: String = s"R($n/$d)"

}
val half = new Rational(1, 2)
val div = new Rational(1, 0)