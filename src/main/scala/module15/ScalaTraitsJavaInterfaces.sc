/* Interfaces in java are traits in scala, Pure Only Without [Method Implementation]
* Scala traits and java Interfaces share an implementation
* In particular if we have a pure abstract scala trait(no method implementation)
* Pure scala traits may be the best solution for java calling scala
* */

trait doSomething{
  def doIt(s: String): String
}

//class Shout Implements doSomething //java extending Interface
class Shout1 extends doSomething{
  override def doIt(s: String): String =
    s"This is a ${s.toUpperCase}"
}
case class Shout2 private() extends doSomething{
  def doIt(s: String): String =
    s"This is a ${s.toUpperCase}"
  // no override
}
object Shout2{
  def apply(x: String): String =
    s"This is companion object $x"
}

new Shout1().doIt("Class")
Shout2().doIt("Case Class")
Shout2("Shout2")

// The world is a lot easier if you call Java from Scala
// than the other way around.