import scala.io.Source

val fileName = "/home/shehzal/obaid_learning/learning/src/main/scala/module2/MyText.txt"
val fileSource = Source.fromFile(fileName)

for (line <- fileSource.getLines()) {
  println(line)
}
fileSource.close()

/**
 * Source is not often used in production code, but it is useful for demos and learning Scala
 */