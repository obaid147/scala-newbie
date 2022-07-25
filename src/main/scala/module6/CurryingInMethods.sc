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
def withFileContents[A](file: File, default: A)(fn: String => A): A = {
  val src = Source.fromFile(file)
  try{
    val x: Option[A] = src.getLines().toSeq.headOption.map{
      line => fn(line)
    }
      x.getOrElse(default)
  } finally src.close()
}

val book = new File("D://abc.txt")

val n: String = withFileContents(book, "")(x => x.toUpperCase)
val m = withFileContents(book, false)(x => x.trim.endsWith("?"))

// find most common letter
withFileContents(book, 'e') { line => // curried with curlies
  val letters = line.toLowerCase.filterNot(_ == ' ').toSeq
  val grouped = letters.groupBy(identity)
  grouped.maxBy { case (char, seq) => seq.length }._1
}
