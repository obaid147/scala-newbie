// This a simple list
val list1: List[Int] = List(1, 2, 3, 4)
// re-written as
val list2: List[Int] = List.apply(1, 2, 3, 4)

/**
 * For lists only, you can also use the cons form of initialization, using ::
 */
val lista = 4 :: 5 :: 6 :: Nil // This is a list initialization, The Nil is an empty list, This line should end with a list

/**
 * :: is right associative, that is, it applies the parameter on the left side to the item on the right, e.g.
 */
val listb = (Nil).::(7).::(8).::(9)

/**
 * Any operator ending in : is right associative in Scala
 * Another list-only operator is concatenate, ::: which joins two lists (again right associative):
 */
val listc = lista ::: listb


