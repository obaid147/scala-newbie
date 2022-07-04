// An expression returns its payload as a return argument with a type, e.g.:
var x = 10
var y = 20
val min = if (x < y) x else y

/* A statement returns Unit and has to have some side effect to be useful: */
if (x > y) println(s"max is $x") else println(s"max is $y")
/**
//Functional programming style prefers expressions over statements
//Remember that if, try...catch, for, and other common constructs in Scala are expressions
//while and do...while are the only built in control flow constructs that only return Unit:
*/
var doIt: Boolean = true
val result: Unit = while (doIt) {
  println("Hello")
  doIt = false
}

// Statements and Expressions
/**
 * val and var also produce Unit return types, this is surprising at first:
 */
var x: Int = 5
val y: Unit = x = 10 // This can be read as val y = (x = 10) where (x=10) is a statement
println(x) // 10
println(y) // ()

/**
 * A common mistake when first learning Scala is ending a code block with a val: */
def add(a: Int, b: Int) = {
  val result = a + b
}
val sum = add(5, 6) // sum will be (): Unit!
//Can be avoided by adding the expected return type Int which is considered good practice

// Instead of val result = a + b, We can write a + b only