// e.g. map, filter, span, partition and more:
/**
 * Higher order functions are just functions (or methods) that take or return other functions
 * If a method or function does not take or return another function, it is
    called a "first order function"
 */

val nums = (1 to 10). toList

nums.map(x => x * x) // List[Int]
val n: Int => Int = x => x * x
nums.map(n)

nums.filter(x => x % 2 == 0) // Takes bool as condition => List[Int]
nums.filter(x => x < 4) // Takes bool as condition => List[Int]

nums.span(x => x % 4 != 0)
// Span will create a first a collection util the predicate is false,
// Once predicate is false, 2nd collection is created with remaining items

nums.partition(x => x % 4 != 0)
// This creates first collection when predicate is true.
// 2nd collection for false predicate.