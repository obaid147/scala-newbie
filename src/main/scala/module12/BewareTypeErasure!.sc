def withIntStringMap(x: Any): Int = x match {
  case m: Map[Int, String] => m.head._1 * m.head._1
  case _ => 0
}

withIntStringMap(Map(2 -> "One"))
// Map(2 -> AnyString) always give 4