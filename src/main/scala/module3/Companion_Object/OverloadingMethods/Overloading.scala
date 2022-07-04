package module3.Companion_Object.OverloadingMethods

class Overloading private (val n: Int, val d: Int){
  require(d != 0)
  println(s"R($n/$d)")
  override def toString: String = s"R($n/$d)"

  def +(other: Overloading): Overloading = {
    new Overloading(
      this.n * other.d + this.d * other.n,
      this.d * other.d
    )
  }

  def +(i: Int): Overloading = {
    this + Overloading(i)
  }
}

object Overloading extends App{
  def apply(n: Int, d: Int): Overloading = {
    new Overloading(n, d)
  }

  def apply(i: Int): Overloading = {
    new Overloading(i, 1)
  }

  Overloading(1, 2) + 5
//  5 + Overloading(1, 2)
}
