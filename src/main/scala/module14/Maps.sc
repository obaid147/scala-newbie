/**
 * Maps are Key -> Value associations where the keys are a Set.
 * Like Sets, Maps have both immutable and mutable implementations.
 *  Map[K, V] extends function K => V
 */
// Maps
val numWords: Map[Int, String] =
  Map(1 -> "One", 2 -> "Two", 3 -> "Three", 0 -> "Zero")


numWords(1)// one -- don't use this
numWords.get(1)// Some(one) -- use this OR
numWords.getOrElse(1, "?")//1 or ? use this

val list = List(1,2,1,3)
// can throw NoSuchElementException exception
list.map(numWords)

for((num, words) <- numWords) println(num,words)
for((num, words) <- numWords) {
  println(s"$num -> $words")
}

//------------------- Sorted and Mutable Map

import scala.collection.immutable
/*Like Set, there are Maps that maintain a sort order*/
val treeMap = immutable.TreeMap.empty[Int, String]
treeMap ++ numWords

/**There is also a ListMap that does maintain insertion order, but
performance is dismal(depressing)*/

// Maps can be mutable too.
/**You can use either ++ operator or
 * Map.++() method to concatenate two or more Maps,
 * but while adding Maps it will remove duplicate keys.*/
import scala.collection.mutable

val mm = mutable.Map.empty[Int, String] ++ numWords

mm -= 2
mm += 2 -> "Two"

// ------------- Maps-Key and Value Operations

/** .keys returns Iterable[KeyType]
It returns an iterator over all the keys of the map.
So, the identical keys are taken only once. */
val keys1: Iterable[Int] = numWords.keys

/** .keySet returns Set
Returns the keys as a set */
val keySet1: Set[Int] = numWords.keySet

/** .values returns Iterable[ValueType]
 * This method returns an iterable containing each
 * value in the map with duplicates.*/
val values1 = Map(1 -> 1, 2 ->2, 3->3, 4->1).values

/** .filterKeys and .mapValues and .transform
 * If we want to filter or map over a Map,
 * We can use filterKeys or mapValues
 * Map.filterKeys(fun) is deprecated.
 * Map.mapValues(fun) is deprecated.
 */
val x = numWords.filterKeys(_%2 == 0)//Not computed
// expected filterKeys -> / Map(2 -> two, 4 -> four)
numWords.mapValues(_.reverse)//Not computed
// mapValues Map(1 -> eno, 2 -> owt, 3 -> eerht, 0 -> orez)
numWords.transform{
  case (k, v) => s"$v($k)"
}
// returns Map with keys and values as value(key)

/** You can also swap keys and values, but beware
 * non-unique values. */
val withoutSwap: Map[Int, String] = numWords
val withSwap: Map[String, Int] = numWords.map(_.swap)
// values become keys and keys become values.

val evens: Map[Int, Boolean] = (for (i <- 0 to 3) yield{
  i -> (i % 2 == 0)}).toMap
// Same keys with boolean values depends on condition.

evens.map(_.swap)
// boolean become keys and Int become values.