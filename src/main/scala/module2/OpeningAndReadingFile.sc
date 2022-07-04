import scala.io.Source

val fName = "/home/shehzal/obaid_learning/learning/src/main/scala/module2/MyText.txt"
val fSource = Source.fromFile(fName)

for (line <- fSource.getLines()) {
  println(line)
}
fSource.close()

/**
 * Source is not often used in production code, but it is useful for demos and learning Scala
 */