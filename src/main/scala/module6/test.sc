import java.io.File
import scala.io.{BufferedSource, Source}

/*
val s: BufferedSource = Source.fromFile(new File("/home/shehzal/ex2.txt"))
val y: Iterator[String] = s.getLines()

while(y.hasNext) {
  println(y.next())
}
*/
val l: List[String] = Source.fromFile(new File("/home/shehzal/ex2.txt")).
  getLines().toList

//val x: String = Source.fromFile(new File("/home/shehzal/ex2.txt")).getLines().toList.head // error head of empty list
val optionValue: Option[String] = Source.fromFile(new File("/home/shehzal/ex2.txt")).
  getLines().toList.headOption

// concatenate "hi" to x

//x.get + " man" //java.util.NoSuchElementException: None.get

optionValue.getOrElse("") + " man"

val res: String = if(optionValue.isDefined) {
  optionValue.get + " man"
} else ""

val pm: String = optionValue match {
  case Some(v) => v + " man"
  case None => ""
}

val l: Option[String] = for {
  v <- optionValue
  res = v + " man"
} yield res

val q: Option[String] = optionValue.map { str =>
  str + " man"
}


val l: List[Int] = List(1,2,3)
val rl: List[Boolean] = l.map(_ > 2)

