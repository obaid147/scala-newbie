// How to create and use partial functions in scala

            // Problem
/**
 * You want to define a Scala function that will only work for a subset of possible input values,
 * or you want to define a series of functions that only work for a subset of input values,
 * and combine those functions to completely solve a problem.
 */

            // Solution

/**
 * A partial function is a function that does not provide an answer for every possible
 * input value it can be given. It provides an answer only for a subset of possible data,
 * and defines the data it can handle.
 * In Scala, a partial function can also be queried to determine if it can handle a particular value.
 */


//As a simple example, imagine a normal function that divides one number by another:
val div: Int => Int = x => 44 / x
//val div = (x: Int) => 44 / x
div(2)
//As defined, this function blows up when the input parameter is zero:
//div(0)

// We can use try catch
/**
 * Scala lets you define the divide function as a PartialFunction.
 * When doing so, you also explicitly state that the function
 * is defined when the input parameter is not zero:
 */

val divide = new PartialFunction[Int, Int] {
  def apply(n: Int) = 42 / n
  def isDefinedAt(x: Int): Boolean = x != 0
}
divide.isDefinedAt(0)

/**
 * Although this code doesn’t explicitly implement the
 * isDefinedAt method, it works exactly the same as the
 * previous divide function definition:
 */
val divide2: PartialFunction[Int, Int] = {
  case d: Int if d != 0 => 42 / d // MatchError for zero
}
divide2.isDefinedAt(0)
// isDefinedAt method dynamically tests to see if the given
// value is in the domain of the function
// (i.e., it is handled, or accounted for).

/**
 * As discussed in other recipes, the => symbol can be
 * thought of as a transformer, and in this case,
 * the (A) => B can be interpreted as a function that transforms
 * a type A into a resulting type B.

The example method transformed an input Int into an output Int,
but if it returned a String instead,
it would be declared like this:
 */

val convertLowNumToStr = new PartialFunction[Int, String] {
  val nums = Array("one", "two", "three", "four", "five")
  def apply(i: Int) = nums(i - 1)
  def isDefinedAt(i: Int) = i > 0 && i < 6
}

val convert6to10 = new PartialFunction[Int, String] {
  val nums = Array("six", "seven", "eight", "nine", "ten")
  def apply(i: Int) = nums(i - 6)
  def isDefinedAt(i: Int) = i > 5 && i < 11
}

//val convertor = convertLowNumToStr.orElse(convert6to10)
val convertor = convertLowNumToStr orElse convert6to10
convertor(6)

// unmatched error, divByZero etc...
// are taken care of by collect method
val test: PartialFunction[Int, Int] =  {
  case d: Int if d != 0 => 44 / d
}

val fg: Int => Int = x => x + 1
(1 to 3).toList.map(fg)
(0 to 3).toList map test //Error
(0 to 3).toList collect test

/**
 * This is because the collect method is written to test the
 * isDefinedAt method for each element it’s given.
 * As a result, it doesn’t run the divide algorithm when
 * the input value is 0(but does run it for every other element).
 */

//You can see the collect method work in other situations,
// such as passing it a List that contains a mix of data types,
// with a function that works only with Int values:
List(1, "hi") collect {case i: Int => i + 1}

// combining of two functions
val myList = List(1, 2, 3, 4, 5)

val isEven: PartialFunction[Int, String] = {
  case even: Int if even % 2 == 0 => s"$even is Even"
}

val isOdd: PartialFunction[Int, String] = {
  case odd: Int if odd % 2 != 0 => s"$odd is Odd"
}

val evenOrOdd = myList map (isEven orElse isOdd)
