val d1 = -1.5 // Double = -1.5
val d2 = 1.5 // Double = 1.5
d1.abs // Double = 1.5
d1 min d2 // Double = -1.5
d1 max d2 // Double = 1.5
d1.floor // Double = -2.0
d2.ceil // Double = 2.0
d2.round // Long = 2

val str = "hello" // String = hello
str.reverse // String = olleh
str.toSeq // Seq[Char] = hello
// scala.collection.immutable.WrappedString, toSeq
str.slice(2, 4) // String = ll

/**
 * Double methods above come from RichDouble
 *        brought in by Predef
 * String methods come from SeqLike and WrappedString also
 *        brought in by Predef
 */