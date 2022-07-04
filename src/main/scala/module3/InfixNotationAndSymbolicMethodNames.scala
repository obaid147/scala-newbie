package module3

  class InfixNotationAndSymbolicMethodNames(val n: Int, val d: Int) {

    override def toString: String = s"R($n/$d)"

    def add(other: InfixNotationAndSymbolicMethodNames): InfixNotationAndSymbolicMethodNames = {
      new InfixNotationAndSymbolicMethodNames(
        this.n * other.d + other.n * this.d,
        this.d * other.d
      )
    }
  }


object InfixNotationAndSymbolicMethodNames extends App{
  val half = new InfixNotationAndSymbolicMethodNames(1, 2)
  val fifth = new InfixNotationAndSymbolicMethodNames(1, 5)
  println(half add fifth)
//  println(half.add(fifth)) infix use of add method
}


