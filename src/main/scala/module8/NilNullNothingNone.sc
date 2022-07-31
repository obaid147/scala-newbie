/**
    Scala has several "negative" types:
     * Nil is the empty List, and is also the terminator of every List
     * Null and its single instance null is the absence of an AnyRef instance
     * Nothing is a type without an instance, and implies an exception being thrown
     *  None is the absence of a Some in the Option type, and is a safer alternative to null
 */

val list = 1 :: 2 :: Nil

val str: String = null
// null is subtype of string and string is subtype of AnyRef

//val int: Nothing = ???
//val string: Nothing = ???
// NotImplementedError

val op1: Option[Int] = Option(1)
val op2: Option[Nothing] = None