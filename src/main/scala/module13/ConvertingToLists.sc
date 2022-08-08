// other type of collections to List
Vector(1, 2, 3).toList

Set(1, 2, 3).toList

Map(1 -> "one", 2 -> "two").toList // List[Int, String]

"hello world".toList// List[Char]

/**
 * Implicits allow a String to be treated as a List of Char
 * in most circumstances.
 */