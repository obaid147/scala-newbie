/**
 * Method that will take a list of integers
 * It will also take a function that allows us
   to compare the neighbors within that list
 * It will group list items in 2's and will let us
   compare each of those neighboring items
 */
def compareNeighbors(xs: List[Int],
              compare: (Int, Int) => Int): List[Int] = {
  for (pair <- xs.sliding(2)) yield
    compare(pair.head, pair(1))
}.toList

compareNeighbors((1 to 10).toList, (a, b) => a + b)

compareNeighbors(List(4, 1, 7, 3, 4, 8),
                 (a, b) => (a-b).abs)

/**
 * The compare: (Int, Int) => Int) is syntactic sugar
   for Function2[Int,Int, Int] and is the idiomatic
   Scala way to write a function literal type
 */

val l = (1 to 5).toList
l.sliding(2).toList
l.grouped(2).toList