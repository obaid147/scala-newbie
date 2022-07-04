import java.io.File

val fileLoc = new File(getClass.getClassLoader.getResource("").toURI)
val filesHere = new File(fileLoc.getParentFile.getParentFile.getParentFile, "module4").listFiles()

var source = None
def fileLines(f: File) = {
  val source = io.Source.fromFile(f).getLines()
  source
}

val forLineLengths =
  for {
    file <- filesHere
    if file.getName.endsWith(".sc")
    line <- fileLines(file)
    trimmed = line.trim
    if trimmed.matches(".*for.*")
  } yield trimmed.length

filesHere.filter(_.getName.endsWith(".sc")).flatMap { file =>
  fileLines(file).filter(_.trim.matches(".*for.*")).map { line =>
    line.trim.length
  }
}

