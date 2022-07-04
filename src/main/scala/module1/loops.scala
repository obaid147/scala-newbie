package module1
/** WHILE
 * Scala has only one true looping construct: while (and the associated do..while)
//  while is a statement, and has no useful return type of its own
//  while is non-functional and is often replaced by foreach or map functions
//  while is still used for various reasons, including performance
 */
object onlyWhile extends App{
  class loops {
    var x = 1

    while (x <= 10){
      println(x)
      x += 1
    }
  }
}

/**
 * while must have a side-effect to do anything useful
 * In Scala, everything has a return type, there is no void
 * Unit is provided as a return type for statements, it has one instance: ()
 */

/**
 * do while
 * While checks the predicate first before running the body of the loop
 * Possibly the body will never be executed
 * Do while executes the body at least once, and checks the predicate to see
 * if it should repeat:
 */
object doWhile extends App{
  var x = 1
  do {
    println(s"the square of $x is ${x * x}")
    x += 1
  }while(x <= 10)
}

//Note the use of string interpolation: s"the square of $x is ${x * x}"


