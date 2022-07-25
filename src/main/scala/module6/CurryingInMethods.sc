import java.io.File
import scala.io.Source

def add3Method(a: Int)(b: Int)(c: Int): Int = a + b + c

add3Method(11)(3)(1)
// When parameter list has one parameter we can use {}
add3Method{3}{1}{7}

def add4Method(a: Int)(b: Int)(c: Int, d: Int): Int = a + b + c + d

add4Method(10)(50)(10, 30)
//add4Method{33}{1}{21, 22} ERROR

/**
 * Often, function parameters are curried in a separate parameter
     * list at the end of the method definition
 */

// Curried Generic Loan
def withFileContent[A](file: File, default: A)(fn: String => A): A = {
  val src = Source.fromFile(file)
  try{
    val x: Option[A] = src.getLines().toSeq.headOption.map{
      line => fn(line)
    }
      x.getOrElse(default)
  } finally src.close()
}

val book = new File("D://abc.txt")

val n: String = withFileContent(book, "")(x => x.toUpperCase)
val m = withFileContent(book, false)(x => x.trim.endsWith("?"))