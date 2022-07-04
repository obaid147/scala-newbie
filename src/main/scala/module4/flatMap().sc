/**
 * flatMap is a combination of map and flatten method.
 * flatMap() method is identical to the map() method,
 * but the only difference is that in flatMap the inner
 * grouping of an item is removed and a sequence is generated.
 */

val name = Seq("Nidhi", "Singh")
//let’s apply map() and flatten() on the stated sequence.

// Applying map()
val result1 = name.map(_.toLowerCase)
//List(nidhi, singh)

// Applying flatten() now,
val result2 = result1.flatten
//List(n, i, d, h, i, s, i, n, g, h)   This is the final result
// -----------------------------------------------------

//let’s apply flatMap() directly on the given sequence.

name.flatMap(_.toLowerCase)
//List(n, i, d, h, i, s, i, n, g, h)
/**
 * So, we can see here that the output obtained in both the cases is same therefore,
 * we can say that flatMap is a combination of map and flatten method.
 */

val list = List(2, 3, 4)

def f(x: Int) = List(x-1, x, x+1)

val res = list.flatMap(y => f(y))
