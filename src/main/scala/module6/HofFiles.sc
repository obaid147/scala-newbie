import java.io.File
import scala.io.{BufferedSource, Source}

def fileContainsQuestion(file: File): Boolean = {
  val source = Source.fromFile(file)
  try {
    source.getLines().toSeq.headOption.map { line =>
      line.trim.endsWith("?")
    }.getOrElse(false)
  } finally source.close()
}

fileContainsQuestion(new File("/home/shehzal/ex2.txt"))


def emphasizeFileContents(file: File): String = {
  val source = Source.fromFile(file)
  try {
    source.getLines().toSeq.headOption.map { line =>
      line.trim.toUpperCase
    }.getOrElse("")
  }

}
emphasizeFileContents(new File("/home/shehzal/ex2.txt"))
// -------------------------------------------------


val newFile = new File("/home/shehzal/ex2.txt")
val source = Source.fromFile(newFile)

def hof[A](file: File, f: String => A, default: A): A = {
  val source = Source.fromFile(file)
  try {
    source.getLines().toSeq.headOption.map { line =>
      f(line)
    }.getOrElse(default)
  } finally source.close()
}


val h1: Boolean = hof(newFile, (x: String) => x.trim.endsWith("?"), false)
val h1: String = hof(newFile, (x: String) => x.trim.toUpperCase, "")

