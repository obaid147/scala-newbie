// Let's create an array:
val arr = Array("scooby", "dooby", "doo")
// Getting items out of an array can be achieved with the apply method:
println(arr.apply(1)) // prints "dooby"

/**
 * Scala has a shortcut for apply, any item (other than a method) followed by
   parens calls apply with the contents of the parens (if any):
 */
println(arr(0)) // prints "scooby", same as arr.apply(0) would

//In fact, the Array creation line above also uses this rule:

Array("scooby", "dooby", "doo")
// is re-written to
Array.apply("scooby", "dooby", "doo")
//which calls the apply method on the companion object using varargs