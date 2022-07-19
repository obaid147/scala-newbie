

(1 to 10).toList.filter(_ % 2 == 0)
//1 to 10 o/p 6,7

(1 to 10).toList.filter(x => x > 5 && x < 8)
//(1 to 10).toList.filter(_ > 5 && _ < 8)

def Function2[T0, T1, T2]() = ???

def compareNeighbors(xs: List[Int], compare: (Int, Int) => Int) ={
  for (triplet <- xs.sliding(2)) yield {
    compare(triplet.head, triplet(1))
  }
}.toList

val nums = (1 to 10).toList
compareNeighbors(nums, _ + _) // can infer types
