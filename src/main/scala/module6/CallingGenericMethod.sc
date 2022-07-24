import java.io.File
import scala.io.Source


def withFileContents[A](file: File, fn: String => A, default: A): A = {
  val source = Source.fromFile(file)
  try {
    source.getLines().toSeq.headOption.map { line =>
      fn(line)
    }.getOrElse(default)
  } finally source.close()
}

val book = new File("D://abc.txt")
withFileContents(book, _.trim.endsWith("?"), false)
withFileContents(book, _.trim.toUpperCase, "")

withFileContents(book, {line =>
  val letters = line.toLowerCase.filterNot(_ == 'i').toSeq
  val grouped = letters.groupBy(identity)
  grouped.maxBy{ case (char, seq) => seq.length}. _1
}, 'e')
