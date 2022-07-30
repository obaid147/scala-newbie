/** BottomClasses.sc */

val s1: String = "hello"
s1.charAt(1) // Char: e
val s2: String = null // subtype of String

try{
s2.charAt(1) // Null pointer exception!
}catch{
  case e: NullPointerException =>
    "NullPointerException"
}
s1.isInstanceOf[String] // true
s2.isInstanceOf[String] // false

/**
 * For isInstanceOf checks, null will always return false
 *  * How can Nothing be useful?
*/
val emptyList: List[Nothing] = List.empty // List[Nothing]
1 :: emptyList // List[Int] = List(1)
"hello" :: emptyList // List[String] = List(hello)

// Is Nothing used for anything
// other than bottom type parameters?
def fail(message: String): Nothing =
  throw new IllegalStateException(message)

fail("This a message passed as an argument")

/** IMPORTANT
 *A method with a Nothing return type must throw an exception
 */
//Why is Nothing useful?
//It completes the type system...