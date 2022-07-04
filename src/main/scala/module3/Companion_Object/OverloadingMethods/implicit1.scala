package module3.Companion_Object.OverloadingMethods
import scala.language.implicitConversions

class implicit1  private (val n: Int, val d: Int) {
  require(d != 0, "Zero denominator!")
  println(s"R($n/$d)")
  override def toString: String = s"R($n/$d)"

  def +(other: implicit1): implicit1 =
    new implicit1(
      this.n * other.d + this.d * other.n,
      this.d * other.d
    )

  /*def +(i: Int): implicit1 =
    this + implicit1(i)*/ //when we write implicit apply no need of this method

}
object implicit1 extends App{
  def apply(n: Int, d: Int): implicit1 =
    new implicit1(n, d)

   implicit def apply(i: Int): implicit1 = // Int to Rational ---> IN type is INT & OUT type is implicit1
    new implicit1(i, 1)

  val half = implicit1(1, 2)
  half + 5
  5 + half
}