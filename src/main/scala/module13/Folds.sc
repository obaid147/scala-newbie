val words = List("four", "four", "char", "word")
val nums = List(2,3,5,8,13,21)

/** Fold and reduce are functions that merges all the elements
 * from the collection and returns a single value.
 *  The difference is that fold allows us to define an initial value.
 *  Due to this property, fold can also manage empty collections.
 */

val emptyList: List[Nothing] = List.empty
//emptyList.reduce(_ + _)
//UnsupportedOperationException
emptyList.fold(1)((a, b) => a + b)

/** foldLeft(n)(fn)
 * Ist arg is initial value and 2nd is function */
val sumNums1 = nums.foldLeft(0)((a,b) => a + b)
val sumNums2 = nums.sum

val productNums1 = nums.foldLeft(1)(_ * _)
val productNums2 = nums.product

val asString = words.foldLeft("")(_ + ", " + _)

/*nums.reduce(_+_)
nums.reduce((a, b) => a + b)*/

/** We can also use foldRight or just fold, but
 * foldLeft works best for List traversal
 */

nums.reduceLeft(_ + _)

// ---------- Fold Alternatives
/**For many common fold operations, there are ready-made
 * alternatives.e.g. for Lists of Numerics */
nums.sum
nums.product

// and for any kind of List where you want to
// create a string representation:
words
words.toString
words.mkString(" ")
words.mkString(", ")
words.mkString("[",",","]")