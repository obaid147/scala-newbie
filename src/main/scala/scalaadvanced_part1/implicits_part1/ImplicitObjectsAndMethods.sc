/**
 * It's not only vals that can be marked implicit, object, class and def can be implicit too.
 *  Implicit classes will be covered later, but let's look at implicit object and implicit def.
 *  The CompareT val definition could also be a def:
*/

abstract class CompareT[T] {
  def isSmaller(i1: T, i2: T): Boolean
  def isGreater(i1: T, i2: T): Boolean
}

def genInsert[T](item: T, rest: List[T])(implicit cmp: CompareT[T]): List[T] = {
  rest match {
    case Nil => List(item)
    case head :: _ if cmp.isSmaller(item, head) => item :: rest
    case head :: tail => head :: genInsert(item, tail)
  }
}

def genSort[T](xs: List[T])(implicit cmp: CompareT[T]): List[T] = {
  xs match {
    case Nil => Nil
    case head :: tail => genInsert(head, genSort(tail))
  }
}

case class Distance(meters: Int)
val distances = List(Distance(10), Distance(1), Distance(5))

// implicit def, Unlike implicit vals, implicit def's can take parameters.
implicit def distCompare: CompareT[Distance] = new CompareT[Distance] {
  override def isSmaller(i1: Distance, i2: Distance) =
    i1.meters < i2.meters

  override def isGreater(i1: Distance, i2: Distance) =
    i1.meters < i2.meters
}

genSort(distances)

// implicit object
implicit object DistCompare extends CompareT[Distance] {
  override def isSmaller(i1: Distance, i2: Distance) =
    i1.meters < i2.meters

  override def isGreater(i1: Distance, i2: Distance) =
    i1.meters < i2.meters
}

/** Context Bounds*/
//def genSort[T](xs: List[T])(implicit cmp: CompareT[T]): List[T]
def genSort[T: CompareT](xs: List[T]): List[T] // because implicit "cmp" was not being used (boiler plate)
// This automatically adds the (implicit someName: CompareT[T]) Parameter.


/* Can we use context bound where we still need to use implicit?????????????*/

/** implicitly*/
//def genInsert[T](item: T, rest: List[T])(implicit cmp: CompareT[T]): List[T]
def genInsert[T: CompareT](item: T, rest: List[T]): List[T] = {
  val cmp = implicitly[CompareT[T]] // implicit "cmp" is used here, we use implicitly method.
  rest match {
    case Nil => List(item)
    case head :: _ if cmp.isSmaller(item, head) => item :: rest
    case head :: tail => head :: genInsert(item, tail)
  }
}

/*We use implicitly[CompareT[T]] to look up the implicit we know must be
there (from the context bounds)*/

@inline def implicitly[T](implicit theImplicit: T): T = theImplicit
// This is the definition of implicitly

