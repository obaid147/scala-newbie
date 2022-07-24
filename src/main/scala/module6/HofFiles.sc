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

fileContainsQuestion(new File("D:/abc.txt"))


def emphasizeFileContents(file: File): String = {
  val source = Source.fromFile(file)
  try {
    source.getLines().toSeq.headOption.map { line =>
      line.trim.toUpperCase
    }.getOrElse("")
  }

}
emphasizeFileContents(new File("D:/abc.txt"))
// -------------------------------------------------

// --------- Generic Program
def hof[A](file: File, f: String => A, default: A): A = {
  val source = Source.fromFile(file)
  try {
    source.getLines().toSeq.headOption.map { line =>
      f(line)
    }.getOrElse(default)
  } finally source.close()
}

val newFile = new File("D:/abc.txt")

val h1: Boolean = hof(newFile, (x: String) => x.trim.endsWith("?"), false)
val h1: String = hof(newFile, (x: String) => x.trim.toUpperCase, "")

