//Not to be confused with Partial Functions
val add3Numbs = (a: Int, b: Int, c: Int) => a + b + c
//val add3Numbs:(Int, Int, Int) => Int = (a: Int, b: Int, c: Int) => a + b + c
//val add3Numbs:Function3[Int, Int, Int, Int] = (a: Int, b: Int, c: Int) => a + b + c
// The type is not optional on the placeholder in this case

//val add6and4 = add3Numbs(6, _, 4)
val add6and4 = add3Numbs(6, _:Int, 4)

add6and4(5)

/**
 * Partially Apply All the Parameters
 */

def add3Method(a: Int, b: Int, c: Int): Int = a + b + c
val add3Functionv1 = add3Method(_, _ ,_) //warning
add3Functionv1(1, 2, 3)

/**
 * alternative when replacing all params
 */

val add3Functionv2 = add3Method _
add3Functionv2(4, 5, 6)

/**
 * Comparing triplets
 */

def compareTriplets(xs: List[Int],
                    compare: (Int, Int, Int) => Int):
                                            List[Int] = {
  for(triplet <- xs.sliding(3)) yield
    compare(triplet.head, triplet(1), triplet(2))
}.toList

compareTriplets((1 to 5).toList, add3Functionv1)
compareTriplets((1 to 5).toList, add3Functionv2)
compareTriplets((1 to 5).toList, add3Method)
// eta expansion, changing method to function literal
// function literals and methods are interchangeable
