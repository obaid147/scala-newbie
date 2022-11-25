import scala.annotation.implicitNotFound

/*Let's say we create a simple Cell(spread sheet) container
  to hold generic items:
*/

/**case class Cell[T](item: T) {
  def *(other: Cell[T]): Cell[T] = this.item * other.item
}*/
//  value * is not a member of type parameter T
/**
 * T is generic, we don't know if there is going to be a * method.
 * We don't want T to be locked to some kind of a single type ie Numeric.
 *
 * How do we make Cell * method that works if cell contains a Numeric,
 * But doesn't even compile if it's non numeric... (=:=)
 * */

/////////////////////////////////////////////////////////////////

/** Type Equivalence =:= */
/* Let's make a new type context bound by Numeric
 * and ask scala to prove that this new type is same as T*/

case class Cell1[T](item: T) {
  // U: Numeric =>  U is Numeric and T=:=U(Evidence) T is one of those.
  def *[U: Numeric](other: Cell1[U])(implicit ev: T =:= U): Cell1[U] = {
    val numClass1 = implicitly[Numeric[U]]
    //numClass2.times(this.item, other.item)//required Cell2[U] Found U
    Cell1(numClass1.times(this.item, other.item))
  }
}

val intCell1 = Cell1(10)
intCell1 * Cell1(2)

val stringCell = Cell1("String")
//stringCell * Cell("abc") //no implicit found


List(1, 2, 3).sum
// requires 2nd implicit arg as Numeric[B] where B >: Int
//List("hey", "there").sum // required Numeric implicit


case class Cell2[T](item: T) {
  def +[U: Numeric](other: Cell2[U])(implicit ev: T =:= U): Cell2[U] = {
    val numClass2 = implicitly[Numeric[U]]
    //numClass2.plus(this.item, other.item)//required Cell2[U] Found U
    Cell2(numClass2.plus(this.item, other.item))
  }
}
val intCell2 = Cell2(20)
intCell2 + Cell2(10)

val stringCell2 = Cell2("Hey, ")
//stringCell2 + Cell2("") // No implicit found evidence Numeric[String]

/** How does it work?
 *
 * Scala provides implicit proof that
 * for all T, T =:= T is always true (in Predef)
*/
@implicitNotFound(msg = "Cannot prove that ${From} =:= ${To}.")
sealed abstract class =:=[From, To] extends (From => To) with Serializable
private[this] final val singleton_=:= =
  new =:=[Any,Any] { def apply(x: Any): Any = x }
object =:= {
  implicit def tpEquals[A]: A =:= A = singleton_=:=.asInstanceOf[A =:= A]
}

/**
 * Note that =:= also extends Function1[From, To]
 * which means that if T =:= U is available,
 * T can be implicitly converted to U
 * This makes:-
 * numClass1.times(this.item, other.item)
 * work, even though this.item is T and numClass is expecting a U,
 * the implicit converts automatically......
 *
 * extends (From => To) is actually an implicit conversion:-
 * When we say T=:=U, first type must be equal to second type.
 * If U is required, and T is available, An implicit conversion
 * is done to make the conversion:-
 * numClass1.times(this.item, other.item)
 *
 * Sometimes implicit conversion is not enough, which leads to
 * SafeCasting.sc file
 * */











