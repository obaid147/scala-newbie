//Var Args in Methods

//Ever wonder how:
val xs = List(1,2,3)
val ys = List(1,2,3,4,5)
//works for different numbers of params?

//We know Scala re-writes to:
val xs = List.apply(1,2,3)
val ys = List.apply(1,2,3,4,5)
//so are there just lots of overridden apply methods?

//Var Args

def sayHello1(s: String*): Unit = {
  println(s(0))
}

sayHello1("Obaid", "fayaz", "wani")
/**
 * The var args parameter has a * after it
 * It must always be the last parameter
 * The parameter comes in as Array[T] for a parameter
   defined item: T*
 */

def sayHello(names: String*): Unit = {
  if (names.isEmpty){
    println("Empty")
  }
  for (name <- names) println(s"Hello, $name")
}
sayHello()
sayHello("Fred")
sayHello("Fred", "Julie", "Kim")


def greet(greeting: String, names: String*): Seq[String] = {
  for (name <- names) yield s"$greeting $name"
}
greet("Hi", "Fred", "Julie", "Kim")


val newNames = List("Name1", "Name2", "Name3")
// greet("Hey ", newNames)
/** Does not compile*/

//For this, we use the expansion operator
/**
 *  Note that if using expansion operator, the original collection type is
retained (in this case, List) instead of converting to Array
 * The expansion operator is occasionally useful, particularly for recursion
over var-args methods
 */
greet("Hi", newNames: _*)
