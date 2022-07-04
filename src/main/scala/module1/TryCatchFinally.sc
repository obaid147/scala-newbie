/**
 * Scala also opts for expressions over statements in exception handling
 */

val divided = try {
  10 / 0
} catch {
  case ae: ArithmeticException => 0
} finally {
  println("Runs always, never affects the result")
  4
}

/**
 * The finally block will always run, but will not return a value (hence its
   only use is side-effecting)
 * If an exception is caught, a value may be returned to recover
 * If an exception is caught, a value may be returned to recover
 * You may also choose to re-throw a caught exception (or throw another):
 * case ae: ArithmeticException => throw new RuntimeException("Can't divide by 0")
 */