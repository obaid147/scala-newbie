val fullList = List(1, 2, 3)
val emptyList = List.empty[Int]

val fullVector = Vector(1, 2, 3)
val emptyVector = Vector.empty[Int]

import scala.collection.mutable
//import scala.collection.immutable

val fullStack = mutable.Stack(1, 2, 3)
val emptyStack = mutable.Stack.empty[Int]

val fullSet = Set(1, 2, 3)
val emptySet = Set.empty[Int]

fullStack == fullList
fullStack == fullVector
fullList == fullVector

fullSet == fullList
fullSet == fullVector
fullSet == fullStack
emptySet == emptyVector
emptySet == emptyList
emptySet == emptyStack

/**Equality between Seq s works based on contents
 * (except Array - use .deep)
 * Consistent construction, empty, toString, etc.
*/