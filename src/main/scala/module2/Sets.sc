/**
 * A Seq (sequence) is an ordered collection of homogenous values that may be repeated
 * By contrast, a Set is an unordered collection of homogenous values that   are unique

 */
val set1 = Set(1,2,3,1,2,4,5) // Produces a Set(5,1,2,3,4)

//A Set cannot be passed to a function expecting a Seq, it is not a sub-type of Seq:
def squareRootOfAll(xs: Seq[Int]): Seq[Double] =
  xs.map(x => math.sqrt(x))

squareRootOfAll(set1) // will not compile