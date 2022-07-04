/**  In Preconditions.sc
 * Could also write require(this.d != 0, "Zero denominator!")
 * this is a reference to the current instance. It is inferred by Scala when
    possible
 */
class Rational(val n: Int, val d: Int){
    require(this.d != 0, "Denominator is zero")
    override def toString: String = s"R($n/$d)"

    def min(other: Rational): Rational = {
        if (( n / d) < (other.n / other.d))
            this else other
    }
}

val half = new Rational(1, 2)
val fifth = new Rational(1, 6)

//val minimum = half.min(fifth) same
val minimum = fifth.min(half)

/**
 * Could have used 'this' for the this.n.double and this.d references in min
 * Note also infix use of min method, equivalent to fifth.min(half)
 */