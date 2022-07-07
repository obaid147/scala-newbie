val listA = List(1,2,3)

val listB = 4 :: 5 :: 6 :: Nil // should always end with empty list

val listC = Nil.::(6).::(5).::(4)

/**
 * Operator ending in : is the right associative
 * right associative applies params on the left side to the item on the right.
 */
val num = 100
val listD: List[Int] = List(1, 2, 3, 4, 5)
val listE: List[Int] = listD.:+(num) // append

val listF: List[Int] = listA ::: listB // concat
