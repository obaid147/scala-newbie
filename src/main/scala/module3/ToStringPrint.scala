package module3

class ToStringPrint(val n: Int, val d: Int) {
  //override def toString: String = s"R($n/$d)"

}
object A extends App{
  val half = new ToStringPrint(1, 2)
  val div = new ToStringPrint(1, 0)
  println(div)
}