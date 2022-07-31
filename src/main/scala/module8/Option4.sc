val numWords = Map(1 -> "OneOne", 2 -> "TwoL", 3 -> "Three")
/**
 * Here we either get 4th letter or None
 */
// compose options with for expressions
def fourthLetter(i: Int): Option[Char] =
  for{
    word <- numWords.get(i) // Some("someString")
    char <- word.drop(3).headOption
    // Drop first 3 letters and give 4th letter
  } yield char

fourthLetter(1)

// Mixing Options and Collections:
def fourthLetterInSeq(numbs: Seq[Int]): Seq[Char] =
  for{
    i <- numbs
    word <- numWords.get(i).toSeq// Some("someString")
    char <- word.drop(3).headOption.toSeq
    // Drop first 3 letters and give 4th letter
  } yield char

fourthLetterInSeq(List(1,2,3))

//In this case toSeq on the options is not required,
// but is recommended .headOption.toSeq

// Collection following an option in a for expression needs toSeq.