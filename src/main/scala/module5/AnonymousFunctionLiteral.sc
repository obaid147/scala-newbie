val numbers = (1 to 5).toList
/**
 * If you call the map method on a list, there is no need to name the function passed
 */

numbers.map(x => x + 1)
numbers.filter(x => x > 3)
numbers.map(x => x  % 2 == 0) // List of boolean
// How function literals works

val fn1: (Int, Int) => Int = (v1, v2) => v1 + v2
fn1(1, 2)

val fn1Copy = new Function2[Int, Int, Int] {
  override def apply(v1: Int, v2: Int): Int = v1 + v2
}
fn1Copy(1, 2)
/**
 * Scala calls the apply method on any object or instance followed immediately by parens.
 * Therefore if we make a class or instance that overrides apply, that will be invoked by a function call.
 * When you create a new instance of a function, that is called a function value
 */