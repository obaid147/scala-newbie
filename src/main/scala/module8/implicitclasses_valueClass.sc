//    Value class(extends AnyVal)

/**
 * The implicit def also means that the Int is actually wrapped in a new instance to run times.
 * (Int is wrapped in a new instance to run times().)
 *
 * adding extends AnyVal avoids this wrapping when possible
 * (and also makes the definition work only outside of an enclosing class):
 */

object ExtendAnyValSyntax{
  implicit class TimesDo(val i: Int) extends AnyVal {
    def times(fn: => Unit): Unit = {
      for(_ <- 1 to i) fn
    }
  }
}

import ExtendAnyValSyntax._
5 times{
  println("Oby")
}

// To extend AnyVal you must:
//Have a single public parametric field
//Have no other state in the class (because there may be no instance to hold the state)
//Behind the scenes, static methods are used
