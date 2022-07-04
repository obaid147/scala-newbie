package module3

class ComplexNum(val real: Double, val imaginary: Double){ // 1
  def this(real: Double) = this(real, 0)
  override def toString: String = s"${real + imaginary}"

//  println(s"${real + imaginary}i")

  // 4
  def +(other: ComplexNum): ComplexNum = {
    new ComplexNum(
      this.real + other.real, this.imaginary + other.imaginary
    )
  }
  // 5
//  def +(d: Double): ComplexNum =  {
//    //new ComplexNum(d, 0) // passes real number d and imaginary as 0 to class and prints the same
//    this + ComplexNum(d) // now only sums
//  }
}

object ComplexNum extends App{
  def apply(real: Double, imaginary: Double) = new ComplexNum(real, imaginary)
  implicit def apply(i: Double) = new ComplexNum(i, 0.0)

  val num1 = ComplexNum(10.0, 20.0)
  println(s"NUM1 = ${num1}i")
  val num2 = ComplexNum(5.0)
  println(s"NUM2 = ${num2}i")
  println(s"NUM1 + 2.0i = ${num1.+(2.3)}i") // 32
  println(s"NUM1 + NUM2 = ${num1.+(num2)}i") // 32
  // 35
}

