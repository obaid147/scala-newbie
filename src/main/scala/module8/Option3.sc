// Working with Option
// Option is supported throughout the core libraries and third party APIs

val numWords = Map(1 -> "One", 2 -> "Two", 3 -> "Three")
numWords(2)
//numWords(4) //NoSuchElementException

// Returns Some or None --> Option Type
val op1: Option[String] = numWords.get(2)
val op2: Option[String] = numWords.get(4)

// Returns String
op1 match {
  case Some(v) => v
  case None => " "
}

// returns String
val op3 = op2.getOrElse("")