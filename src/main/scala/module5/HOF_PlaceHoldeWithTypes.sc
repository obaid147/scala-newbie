def compareNeigh(xs: List[Int], compare: (Int, Int)/*here scala will infer type if not given while calling*/ => Int): List[Int] ={
  for(pair <- xs.sliding(2)) yield compare(pair.head, pair(1))
}.toList
//compareNeighbours((1 to 5).toList, (a, b) => a + b)
/** scala can infer, type below */
compareNeigh((1 to 5).toList, _ + _) // scala infers type
/** explicit type below */
compareNeigh((1 to 5).toList, (_: Int) + (_: Int))

/**
 * If you define a function literal where Scala has
nothing to infer from, the types are mandatory:
 */
val addPair = (_: Int) + (_: Int) // here type is mandatory coz scala has nothing to infer type from
compareNeigh((1 to 5).toList, addPair)

val addPair2 = (a: Int, b: Int) => a + b
compareNeigh((1 to 5).toList, addPair2)

//val addPair = _ + _ will not compile,
// val addPair2 = (a, b) => a + b will not compile,
//since Scala does not have enough information
// to infer the types