val oneTwo = List(1, 2)
val threeFour = 3 :: 4 :: Nil
val oneTwoThreeFour = oneTwo ::: threeFour

/** List Properties */
/**
 * Immutable, We cannot update / edit lists.
 * Head Operations are performance and memory efficient.
 * Always terminated by the singleton Nil.
 * Simple implementation.
 */
// Nil is (List[Nothing]) and :: is (item :: T, tail: List[T])
