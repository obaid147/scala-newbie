/**
 *So far we have looked at simple types like Int, String, and Unit, also our methods have returned just one of these
 * What if we want to return more than one thing from a method? Enter tuples
 */

def sumAndDifference(a: Int, b: Int): (Int, Int) = {
  val sum = a + b
  val difference = a - b
  (sum, difference)
}
// Getting the result parts:
val results = sumAndDifference(10, 5)
results._1
results._2
// 15: Int
// 5: Int
// LENGTH OF TUPLE
var n = results.productArity

/**
 *The types are carried through, _1 and _2 can be thought of as item 1 and item 2
 * There's a nicer way to get the parts:
 */
val (sm, df) = sumAndDifference(10, 5)

/**
 * And the tuple can have more than 2 items, and mixed types:
 */
val (a,b,c,d,e) = (0, 'u', 8, 1, "too")
a // 0: Int
b // 'u': Char
c // 8: Int
d // 1: Int
e // "too": String

/**
 * Tuples can have arity(length) up to 22, because it had to stop somewhere
 * Future versions of Scala may (probably will) create tuple arities on the fl
*/