/**
 * List and Array are both sequences in Scala, subtypes of Seq
 * There are others, notably Vector:
 */

val v = Vector(1,2,3,4)
val lista = 4 :: 5 :: 6 :: Nil
val listb = (Nil).::(7).::(8).::(9)
val listc = lista ::: listb
val array1 = Array(1,2,3)
//All can be passed in to a method requiring a Seq of the right type:
def squareRootOfAll(xs: Seq[Int]): Seq[Double] =
  xs.map(x => math.sqrt(x))
/**
Now, List[Int], Array[Int] and Vector[Int] can all be passed in:
*/
    val n1: Seq[Double] = squareRootOfAll(v) // Vector[Double]
    val n2: Seq[Double] = squareRootOfAll(listc) // List[Double]
    val n3: Seq[Double] = squareRootOfAll(array1) // ArraySeq[Double]
