/**
 * Array is mutable, may be grown, values may be updated, etc.
 * List and Vector are immutable, once created the only way to change the
    size or update them is to transform them into another reference (or use a var to reassign the reference)
 * Set has both mutable and immutable implementations:
 */

import scala.collection._

val arr = Array(1,2)
arr
arr(0) = 100
arr

val l1 = List(1, 2)
val l2 = l1 :: 1 :: Nil

val s1 = mutable.Set(1,2,3)
var s2 = immutable.Set(1,2,3)

//Now if we use += on both of these:
s1 += 4 // works because s1 has a += operator, We used mutable from collection
s2 += 4 // works because s2 is a var

/**
 * For s2, Scala uses a re-writing rule to the expression to s2 = s2 + 4
 * It is not required (nor recommended) to use a var and a mutable collection together
 */