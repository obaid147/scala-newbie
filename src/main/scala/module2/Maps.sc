Map(1 -> 2)
/**
 * A Map can be thought of as an associative sequence of tuple2s
 * The first item of the tuple can be used to look up the second item(Key Value)
 * Like Sets, Maps have both mutable and immutable implementations
 */

import scala.collection._

val m1 = mutable.Map('a' -> 1, 'b' -> 2, 'c' -> 3)
var m2 = immutable.Map('a' -> 1, 'd' -> 4, 'e' -> 5, 'f' -> 6)

/**
 * concatenating two maps which returns hashMap
 * Removes the duplicates
 */
m1 ++= m2 // calls ++= on the mutable map

//Updating the map
m2 += 'g' -> 7 // re-writes to m2 = m2 + 'g' -> 7

m1 // returns hashMap
m2 // Map

/**
 * What's this 'g' -> 7 syntax about?
 * It's not syntax, it's an extension method
 */

// Map Iteration