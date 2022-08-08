val words = List("four", "five", "char", "word")
val numbers = (1 to 10).toList

/**A predicate is just a function returning Boolean,
 * as such predicate based functions are higher order functions */

words.map(_.contains("s")) // checks and returns List[Boolean]
words.filter(_.contains("o"))
// check and returns List[String]. if no match returns empty list.

/** find returns an Option[T] */
words.find(x => x.contains("v"))
words.find(x => x.contains("s"))

/** returns index of String with a matching char else -1 */
words.indexWhere(_.contains("a"))//returns 2 as char is at index 2
words.indexWhere(_.contains("z"))// -1 not found.
words.indexWhere(_.contains("r"))//returns 0 coz four at index 0.

/** Starts at the end of the Seq */
words.lastIndexWhere(_.contains("r"))// found word returns 3 index.

/** When no match returns everything. When matched,
 * excludes the element from the returned Seq*/
words.filterNot(_.contains('a'))// opposite to filter.

/** Partitions the strings as List(matchedStrings)
 * when matched char is found.
 * returns empty List with actual list as
 * tuples(List[T], List[T])*/
val t = words.partition(_.contains("S"))

/** Get elements from the list as long as predicate is true.
 * Once predicate is false, return*/
numbers.takeWhile(_ < 5)

/** Pen  */
val num = List(1, 3, 5, 4, 2)
num.dropWhile(_ % 2 != 0)



