import scala.concurrent.Future

/**
 * Only one parameter list can be implicit, and it must be the last parameter list.
 * The implicit parameter list starts with the implicit keyword.
 * All parameters in the list are implicits.
 * Parameters may be supplied explicitly (but if so, all of them must be supplied).
 * Implicit values, objects or defs must be imported directly into scope by name.
 * Scala will not apply an implicit if the code will compile without doing so.
 * */

//1. Only one parameter list can be implicit, and it must be the last parameter list.
implicit val i: String = "s"
def m1(a: Int)(implicit b: String): String = a + b
//def x(a: Int)(implicit b: String)(c: Int): String = a + b


//2. All parameters in the list are implicits.
def m2(a: Int)(implicit b: String, c: Int): String = a + b
//m2(1) No implicit found for c: Int


//3. Parameters may be supplied explicitly (but if so, all of them must be supplied).
def m2(a: Int)(implicit b: String, c: Int): String = a + b
//m2(1)(2) unspecified parameter
m2(1)("str", 2)


//4. Implicit values, objects or defs must be imported directly into scope by name.
import scala.concurrent.ExecutionContext.Implicits.global

val f = Future{
  10
} // requires EC

// Scala will not apply an implicit if the code will compile without doing so.


