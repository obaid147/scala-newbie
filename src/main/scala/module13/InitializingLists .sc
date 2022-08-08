/**Lists have a factory method on the List companion object*/
val oneTwo = List(1, 2)
val threeFour = 3 :: 4 :: Nil
// :: is right associative ie: Final item must be Nil.

/** List companion object have Factory methods for initialization*/
List.fill(10)(2) // initialize with an element 2 times 10.
List.tabulate(10)(_ => 1)//initialize with an element 1 times 10.
List.tabulate(10)(x => x + x)
//List.tabulate(n)(x => x + x) takes 2 args currying ist arg as Int and 2nd arg function.
//uses a function as 2nd arg. and can do operations of n items
List.range(1, 10) // returns List from start to end, excluding end.
