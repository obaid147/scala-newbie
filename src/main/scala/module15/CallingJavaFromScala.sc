/*Calling Java from Scala
Import any Java library
Call Java methods just like Scala
Can leave off ()s for empty params
Can call using infix notation
Can extend or "with" Java interfaces
Can instantiate Java classes
Scala handles conversion to/from primitives(boxing unboxing)
because at compile time the type is not known.
In Scala 2.12, SAMs can be satisfied with Scala functions
Single Abstract Methods(Lamda's are done in java)
* */

import java.time._
val zdt = ZonedDateTime.now // now() empty params

val s = "hey"
// This is a java.lang String
s.charAt(1)
s charAt 1 // Infix call
