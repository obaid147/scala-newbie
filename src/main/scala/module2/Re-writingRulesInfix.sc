/** INFIX */
// Scala has no operators (as such), although it appears to:
val x = 1 + 2 // 3

// So what's + if it's not an operator? A method! The above can be re-written:
val y = 1.+(2)
/**
 * This is known as infix notation, it works for all methods on an instance with one parameter, e.g.
 */
val s = "hello"
s.charAt(1) // can be re-written as below:
s charAt 1

/**
 * It does not work without an instance before the method though:
 */
/// println "hello"     will not compile, needs parens:
