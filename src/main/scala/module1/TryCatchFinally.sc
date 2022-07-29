import java.io.FileReader
import java.io.FileNotFoundException
import java.io.IOException
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
 * You may also choose to re-throw a caught exception (or throw another):
 * case ae: ArithmeticException => throw new RuntimeException("Can't divide by 0")
 */

val xy = try {
  // Creating object for FileReader
  val t = new FileReader("noFIle.txt")
} catch {
  case x: FileNotFoundException =>
    // Displays this if the file is
    // missing
    println("Exception: File missing")
    1
  case x: IOException   =>

    // Displays this if input/output
    // exception is found
    println("Input/output Exception")
    2
}
