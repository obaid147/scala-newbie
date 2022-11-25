import scala.language.implicitConversions

/** Takes one type and implicitly converts into another type...*/

case class Complex(real: Double, imaginary: Double = 0.0) {
  override def toString: String = s"$real $sign ${imaginary.abs}"

  private def sign: String = if (imaginary >= 0) "+" else "-"

  def +(other: Complex) =
    Complex(real + other.real, imaginary + other.imaginary)

  /*def +(other: Int) =
    Complex(real+other, imaginary)*/
}
object Complex { /** CONVERSION inside companion */
  implicit def intToComplex(i: Int): Complex =
    Complex(i)
} // When we do so, It works both ways c1 + 1 and 1 + c1

val c1 = Complex(5, 7)
val c2 = Complex(-3, -5)

c1 + c2

//c1 + 8.8 //mismatch, we can overload +()
c1 + 1 // works

/** What about 1 + c1,
 * This won't work because There is no type/method for Int called complex.
 * Boxing/UnBoxing*/

// Commend the Overloaded +()
1 + c1 //convert integer to complex and add complex to complex.
c1 + 2 //convert integer to complex and add complex to complex.

/** It gets reWritten as:-*/
Complex.intToComplex(1) + c1 // and
c1 + Complex.intToComplex(2)

/*Scala does this for us because we marked intToComplex as implicit*/

