/**
 *
 * Distinct subgroup within function literals.
 * Closures are subset of function literals.
 * All closures are function literals, but not all function literals are closures
 * A closure is so-called because it encloses around some other state
   than that passed in to the function as parameters
 * In Scala, closures can be made over vars!
 * This is confusing, and usually unintentional. Don't do that! Take a
   defensive val copy of any state before using it
 */

val incBy1 = (x: Int) => {x + 1}: Int
// This is not a closure. This is a function literal
// x is passed in and 1 is just a constant.

val more = 10: Int
val incByMore = (x: Int) => x + more
// This function depends on (more and x)
// function literal grabs a handle to this "more"
// and sucks it into the function and that makes it a closure.
// That process of bringing that state in from outside and enclosing around it makes it a closure

incBy1(10)
incByMore(10)

// * In Scala, closures can be made over vars!
// use val
var more2 = 10
val incByMore2 = (x: Int) => {
   more2 += 1
   x + more2
}

incByMore2(1)
incByMore2(1)
incByMore2(1)
//This is confusing, and usually unintentional. Don't do that!
// Take a defensive val copy of any state before using it

val userDir = () => {System.getProperty("user.dir")}
println(userDir)

/**
 * Scala Closures are functions which uses one or more free variables and
   the return value of this function is dependent of these variable.
 * The free variables are defined outside of the Closure Function and
   is not included as a parameter of this function.
 */