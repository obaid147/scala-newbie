

case class Distance(meters: Int) {
  def larger(other: Distance): Distance = if (other.meters > this.meters) other else this

  def smaller(other: Distance): Distance = if (other.meters < this.meters) other else this

  def >(other: Distance): Boolean = this.meters > other.meters

  def <(other: Distance): Boolean = this.meters < other.meters
}

/** Insertion sort implementation */
/*The Distance class definition simply uses Distance
 when being defined*/
val d1 = Distance(10)
val d2 = Distance(12)

d1 larger d2 // who is larger d1 or d2
d1 > d2 // is d1 larger than d2
d1 < d2 // is d1 smaller than d2
d1 smaller d2 // who is smaller d1 or d2

/** Sorting by Distance */
def insertDistance(item: Distance, rest: List[Distance]): List[Distance] = {
  rest match {
    case Nil => List(item)
    case head :: _ if item < head => item :: rest
    // < here is the method defined above that compares 2 Distance instances.
    case head :: tail => head :: insertDistance(item, tail)
  }
}

def sortDistance(xs: List[Distance]): List[Distance] = xs match {
  case Nil => Nil
  case head :: tail => insertDistance(head, sortDistance(tail))
}

sortDistance(List(d2, d1))

/** RECURSIVE TYPES */
object RecursiveTypes {
  trait CompareT[T] {
    // Named CompareT not to confuse with scala's inbuilt Compare trait.
    def >(other: T): Boolean
    def <(other: T): Boolean
  }

  def genInsert[T <: CompareT[T]](item: T, rest: List[T]): List[T] =
    rest match {
      case Nil => List(item)
      case head :: _ if item < head => item :: rest
      // < is from compareT trait. and CompareT is required to use <
      case head :: tail => head :: genInsert(item, tail)
    }

  // to satisfy the condition, we should upperbound T by CompareT[T]
  def genSort[T <: CompareT[T]](xs: List[T]): List[T] = xs match {
    case Nil => Nil
    case head :: tail => genInsert(head, genSort(tail))
  }

  // More generic case class Distance that extends trait of type itself
  case class Distance(meters: Int) extends CompareT[Distance] {
    def >(other: Distance): Boolean = this.meters > other.meters
    def <(other: Distance): Boolean = this.meters < other.meters
  }

  val distanceList = List(Distance(10), Distance(12), Distance(4))
  val res = genSort(distanceList)

  // Something other than numbers.
  case class Person(first: String, last: String, age: Int)
  extends CompareT[Person] {
  def >(other: Person) =
    if(last > other.last) true else first > other.first
  def <(other: Person) =
    if(last < other.last) true else first < other.first
  }
  val persons = genSort(List(
    Person("Harry", "Potter", 20),
    Person("Charles", "Potter", 20),
    Person("Harry", "Dumbledor", 45)
  ))
}

// RecursiveTypes.res
RecursiveTypes.persons

/**
 * We can now easily re-use our insert method for any new type
    as long as it extends CompareT of itself.
 * This is a common pattern in Scala, and carries the name
    F-Bounded Polymorphism.
 * Since the type T refers to itself in the definition,
    it is also called a Recursive Type.

 * */

