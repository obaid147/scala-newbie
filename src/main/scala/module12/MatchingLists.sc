// For Lists specifically, you can use :: (cons) notation for matches:
def matchList(xs: List[Int]): String = xs match {
  case 1 :: 2 :: rest => s"A 1, 2 list followed by $rest"
  case a :: b :: _ => s"A list of at least 2 items, starting with $a, $b"
  case a :: Nil => s"A single element list of $a"
  case Nil => "The empty list"
}
matchList(List(1,2,3))
matchList(List(1,2))
matchList(List(1,3,4))
matchList(List(4))
matchList(Nil)

// very common to see case head :: tail => in recursive functions
