/**   <:
It means an abstract type member is defined
(inside some context, e.g. a trait or class),
so that concrete implementations of that context must define that type.
However, there is a constraint that this type (Currency) must actually
  be a subtype of AbstractCurrency.
That way the abstract context can operate with Currency,
knowing that it understands every operation of AbstractCurrency. */

// Traits can have type parameters:
trait CompareAge[T]{
  def older(item: T): T
}
//    <: abstract type member is defined
def getOlder[T <: CompareAge[T]](item1: T, item2: T): T = item1.older(item2)

case class VintageCar(make: String, model: String, year: Int)
  extends CompareAge[VintageCar] {
  def older(other: VintageCar): VintageCar =
    if (this.year < other.year) this else other
}
getOlder(
  VintageCar("Ford", "Mustang", 1965), // item1
  VintageCar("Ford", "Model T", 1922)) // item2

// Another CompareAge class
case class Person(name: String, age: Int) extends CompareAge[Person] {
  override def older(other: Person) =
//    if (other.age > this.age) other else this
  age match {
    case _ if other.age > this.age => other
    case _ => this
  }
}
getOlder(Person("Fred", 25), Person("Jill", 28))

//  This is used in the Scala core libraries, e.g. Ordering
val people = List(Person("Fred", 25), Person("Jill", 28), Person("Sally", 22))
//people.sorted // Error: No implicit Ordering defined for Person

implicit object PersonOrdering extends Ordering[Person] {
  override def compare(x: Person, y: Person) = x.age - y.age
}
people.sorted
// List(Person(Sally,22), Person(Fred,25), Person(Jill,28))
/*A trait with a single type parameter is often
referred to as a type class. A widely used pattern in Scala.*/