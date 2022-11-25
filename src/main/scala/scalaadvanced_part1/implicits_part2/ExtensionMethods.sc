import scala.language.implicitConversions

/** one of the thing Implicit conversions are used for is to add
 * Extension Methods to existing types without having to change the inheritance hierarchy*/

/** Whenever we are doing an implicit conversion
 * from one type to another,
 * One of the types should be our defined type / belongs to us and
 * other one can be anything.
 * */
class SimpleTimesInt(i: Int) {
  def times(fn: => Unit): Unit = {
    for (_ <- 1 to i) fn
  }
}

implicit def intToTimeInt(i: Int): SimpleTimesInt =
  new SimpleTimesInt(i)

5 times {
  println("hey")
}

// reWritten as
intToTimeInt(5).times { println("hey") }


/** We can mark class as implicit and get rid of the implicit method*/
implicit class ImplicitTimesInt(i: Int) {
  def timesImplicit(fn: => Unit): Unit = {
    for (_ <- 1 to i) fn
  }
}

5 timesImplicit{ println("Hi") }
// automatically converts, and we have one defied as our type


/** DOWNSIDE:-
 * There is implicit conversion that is defined for us by
 * scala and as a result,
 * We can't just put these implicit class at topLevel.
 * They need to go inside of some other container because
 * we can't have methods in JVM that arnt inside some other object */