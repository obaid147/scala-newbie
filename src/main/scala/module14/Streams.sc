/**
 * Lazy, potentially infinite collection allowing custom implementations.
 * Note that Stream is tricky, it memoizes. You must drop or tail to release
  earlier references and free up memory. */
//memoization is an optimization technique that makes applications more efficient and hence faster.

/*val callStreamFrom1 = Stream.from(1)
val first10Nums = callStreamFrom1.take(10)
first10Nums.toList*/

/**
 * Stream is deprecated, It has lazy tail only.
 * LazyList is fully lazy.
 */

val callFrom1 = LazyList.from(1)
val first10Nums = callFrom1.take(10)

first10Nums.zipWithIndex.toMap
first10Nums.toList
  // first item is 1 next item is 1*2, 2*3, 6*4, 24*5, 120*6 ... 362880*10
def factorial: LazyList[BigInt] = 1 #:: factorial.zip(LazyList.from(2)).
  map{
    case(a, b) => a * b
  }

factorial.take(10).toList

def fib: LazyList[BigInt] = {
  BigInt(0) #:: BigInt(1) #:: fib.zip(fib.tail).
    map{
      case (x, t) => x + t
    }
}
fib.take(10).toList
//   #:: is lazy cons
Stream