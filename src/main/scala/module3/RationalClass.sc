/**
 * As in, let's make something to represent a Rational number from what we
   know so far:
 */

class Rational(val n: Int, val d: Int)
val half = new Rational(1, 2 )// half: Rational = Rational@address

/**
 * Every class has a toString method that can be overridden:
 */

class Rational(val n: Int, val d: Int){
  // we are not dividing 2 numbers here
   override def toString: String = s"R($n/$d)"


}
val half = new Rational(1, 2)
val div = new Rational(1, 0)

/**
 * The String field in require is optional but recommended
 * If you use require and the predicate fails, you will get an
    IllegalArgumentException thrown
 */