package scalaadvanced_part1.implicits_part2

import scala.language.implicitConversions

/**
 * 1. Scala looks for implicits in companion object at the end if it was not able to find one before that.
 *
 * 2. Package object is another place to put in implicits.
 *
 * 3.
 * */
import scalaadvanced_part1.implicits_part2.WhereToPutImplicits._
//import scalaadvanced_part1.implicits_part2.WhereToPutImplicits.Complex // will not bring it in

package object Complex {
  /** CONVERSION inside companion */
  implicit def intToComplex(i: Int): Complex = Complex(i)
}


object WhereToPutImplicits {

  case class Complex(real: Double, imaginary: Double = 0.0) {
    override def toString: String = s"$real $sign ${imaginary.abs}"

    private def sign: String = if (imaginary >= 0) "+" else "-"

    def +(other: Complex): Complex =
      Complex(real + other.real, imaginary + other.imaginary)
  }
}

/*Same rules/recommendations for implicit class definitions as implicit conversions, implicit parameters */