def withIntStringMap(x: Any) = x match {
  case m: Map[Int, String] => m.head._1 * m.head._1
  case _ => 0
}

/*Scala will match the Map vs not, but will believe you on the inner erased
  types, so you can get:*/
  withIntStringMap(Map(2 -> "two")) // 4 - as expected
withIntStringMap(List(2)) // 0 - not a match
withIntStringMap(Map("One" -> 1)) // ClassCastException!
/*
The safe way to match erased type parameters is case m: Map[_, _]
Alternatively, type-tags can be used - see advanced course*/

def listOfStringToInt(list: List[String]): List[String] = list match {
  case x: List[Int] => List(x.head) //programmer's error x.head.toInt
  case _ => "" :: Nil
}

//type erasure
//
val n: List[Int] = listOfStringToInt(List("One", "Two"))

// l: List[Int] = List[String]("one")

1 == "str"

