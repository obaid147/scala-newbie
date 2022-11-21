import scala.annotation.implicitNotFound

/**A type-class is another name for a trait or abstract class with a single
generic type parameter and abstract method(s) defined for that type*/

@implicitNotFound("You need to define a CompareT for ${T}")
abstract class CompareT[T]{
  def isSmaller(i1: T, i2: T): Boolean
  def isGreater(i1: T, i2: T): Boolean
}

def genInsert[T](item: T, rest: List[T])(implicit cmp: CompareT[T]): List[T] = {
  rest match {
    case Nil => List(item)
    case head :: _ if cmp.isSmaller(item, head) => item :: rest
    case head :: tail => head :: genInsert(item, tail)
  }
  /*We call genInsert recursively without implicit param.
   *Which means implicit cmp is available inside genInsert() scope.*/
}

/**
 * Make "implicitCompare" & ""implicitDistCompare implicit
 * or you will see a compile time error message @implicitNotFound.
 */
implicit val implicitCompare: CompareT[Int] = new CompareT[Int] {
  override def isSmaller(i1: Int, i2: Int) = i1 < i2
  override def isGreater(i1: Int, i2: Int) = i1 > i2
}


def genSort[T](xs: List[T])(implicit cmp: CompareT[T]): List[T] = {
  xs match {
    case Nil => Nil
    case head :: tail => genInsert(head, genSort(tail))
  }
  /* why do we use implicit cmp here???
  * Because we use genInsert here so,
  *  we have to prove that implicit exists here as well.
  */
}

genSort(List(1,4,2,3,5))

//Providing Implicit TypeClasses
/** above, we provided TypeClass ---> implicitCompare*/

case class Distance(meters: Int) // no-inheritance

val distanceList = List(Distance(10), Distance(4), Distance(8))

//genSort(distanceList)
//could not find implicit value for parameter cmp: CompareT[Distance]

/** Need that type-class*/

implicit val implicitDistCompare: CompareT[Distance] = new CompareT[Distance] {
    override def isSmaller(i1: Distance, i2: Distance) =
      i1.meters < i2.meters

    override def isGreater(i1: Distance, i2: Distance) =
      i1.meters > i2.meters
}

genSort(distanceList) // implicit param implicitDistCompare
//genSort(distanceList)(implicitDistCompare) // explicitly


/** More Idiomatic way*/
implicit object DistanceCompare extends CompareT[Distance]  {
  override def isSmaller(i1: Distance, i2: Distance) =
    i1.meters < i2.meters

  override def isGreater(i1: Distance, i2: Distance) =
    i1.meters > i2.meters
}
