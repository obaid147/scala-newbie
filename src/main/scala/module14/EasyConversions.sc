val arr = Array(1, 2, 3, 4)
val xs = List(1, 2, 3, 4)

arr == xs
//list = arr.deep


xs.toVector
xs.toArray
xs.toSet
xs.zipWithIndex.toMap
//xs.toQueue
import scala.collection.immutable
//xs.to[immutable.Queue]

/**
 * toList on a List is a no-op (so you can call these with little-to-no overhead) */
xs.toList