/**
 * Nulls are discouraged in Scala.
 * But they are a fact of life in Java libraries. */
  // --------- Nulls to Options
def foo(x: String): Option[String] = {
  x match{
  case null => None
  case e => Some(e)}
}

foo(null)
foo("ABC")

// ----------- Options to Nulls
/** imagine a Java method that accepts nulls.*/

val s1: String = "hey"
val s2: String = null

val os1 = Option(s1)
val os2 = Option(s2)

os1.orNull
os2.orNull
/** orNull on Option returns either the contents or a
 * null reference (if None) */
