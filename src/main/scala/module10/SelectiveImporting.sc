import scala.collection.immutable.{HashMap, HashSet}

/**  Importing just two packages
 * Import just HashSet and HashMap from immutable
 */
HashSet(1, 2, 3)
HashMap(1 -> "One", 2 -> "Two", 3 -> "Three")


/** import everything except few packages
 * Import _ means everything
 * renaming any import to _ means point to nothing 0r just don't import.
 * */

import java.util.{ArrayDeque => Deque, Date => _, Deque => _, _}
new Array[Int](3) // java.util.ArrayList[Int] = []
//new ArrayDeque[Char](10) compile time error ArrayDeque not found
new Deque[Int](10)
//new Date compile error


/** Standard imports for all source files:- */
/**
import java.lang._ // everything in the java.lang package
import scala._ // everything in the scala package
import Predef._ // everything in the Predef object
 */