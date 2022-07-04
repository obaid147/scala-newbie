//   "/home/shehzal/obaid_learning/learning/src/main/scala/module2/MyText.txt"

//val args = Array.empty[String]
val args = Array.apply("1", "2", "3")

val fileName =
  try{
    args.head // throws exception on empty array
  }
  catch{
    case ae: NoSuchElementException => "/home/shehzal/obaid_learning/learning/src/main/scala/module2/MyText.txt"
  }
  finally {
    println("weeeeeeeee")
    "the finally block"
  }

/**
 * The result and type are decided by try and catch
 */

val int = 10
val boolean = true
val intOrBoolean = if(boolean) boolean else int

/**
 * The scala compiler does not know weather its going
    to be an Int or a boolean that comes back out of this.
 * It finds the most specific, common supertype to both
    of those classes which is an AnyVal.
 * The if expression returns the executed branch of code is based
 * on the predicate is passed into it, but the compiler
 * type is established by comparing the both sides, if & else.
 * But in the case of a try, the type that you get back is based on the type of the try block.

So in other words, the last thing that's evaluated in the try block, whatever the type is there and

the type that comes back from the catch.

Okay, but that's because if try works, you get item IBRC and if the try fails, you get whatever the

handler does in the catch.

So this is why when you do something like this, Val filename is either the args head, which would

be a string or default text.

In this case you'd get a string.
 */

  // Here compiler doesnt know what could be returned
val bool = false
try{
  require(bool, "bool should be true")
  bool
}
catch{
  case ae: IllegalArgumentException => 0
}
finally{
  println("Finally Called")
  "PACK"
}

/**
 *  the finally block is something that always runs.
 *  But the result of the finally block and the type
of that expression do not affect the overall expression.
 *  So it doesn't matter what the final block returns,
 *  it will never be used and it will never affect the type that comes back or that is inferred for this.
 *
 * Only the try and catch feed into that finally is only
    useful for side affecting things.

 * And in particular, it's useful if you end up opening a
   file or something like that or connecting to a database
   and you need to disconnect from it to make sure
   that resource hasn't been leaked.
 */
