/**
 * 1. PRECONDITIONS refers to some conditions in scala that needs
      to be fulfilled before moving further with the code/program.

 * 2. Designing by Contract(DbC), is a designing process that
      gives significance and meaning to scala preconditions.

 * 3. Bertrand Meyer, gave the DbC approach and it offers some
      pre and post conditions to a code block which if not
      satisfied, throws an exception.

 * 4. Scala preconditions are a set of major functions that have
      different conditions a programmer must follow while designing
      a software. These functions come in Predef.scala package
      and one does not have to import any separate package.
 */

/**                The exceptions are checked at run time.
 *  Assert – For general assertions:-
    assert() is a method of asserting a condition in all execution
    paths or to check an INVARIANT condition throughout the program.

 *  Assume - Stating an Axiom:-
    assume(), on the other hand, is used to reduce the load on the
    static analyser (debugging that is done by examining the code
    without executing the program.)
    It works locally to develop a divide-and-rule mechanism to help
    the analyzers to assume a condition and go through checking the
    code.
 * */
//assert(2 > 3)
//assume(2 > 3)
//(1 + 1) ensuring (_ > 3)

/**These can (and should) include String explanations*/
val x: Int = 2
//assert(x > 3, "x must be larger than 3")
//assume(x > 3, "x must be larger than 3")
//(x - 1) ensuring (_ > 3, "x is not greater than 3")
// scala -Xdisable-assertions using this we prevent assert and assume
// to throw an exception, but ensuring till throws

def square(x: Int): Int = {
  x * x
}ensuring(_ >= 0, "Square cannot be negative")
square(3)

/** assert and assume can be elided(omitted)
 * But ensuring still throws...*/

//scala -Xdisable-assertion
/*
scala> val x = 2
x: Int = 2
scala> assert(x > 3, "x must be larger than 3") //Works
scala> assume(x > 3, "x must be larger than 3") //Works
scala> (x - 1) ensuring (_ > 3, "x is not large enough") //Error
java.lang.AssertionError: assertion failed: x is not large enough
at scala.Predef$Ensuring$.ensuring$extension3(Predef.scala:219)
... 29 elided*/

/**
 * Since assert and assume can be turned off,
 * we have require (and requireState) which always throw on failure.
 * */

//require(x < 0, "x must be negative - require")
/**require, and requireState from Scalactic are idiomatic,
assert and assume less so*/
//import org.scalactic.Requirements._
//requireState(x < 0, "x must be negative -requireState")
/** if we only import Requirements.requireState,
 * Program will throw an TypecheckException exception
 * no found: value requirementsHelper */

