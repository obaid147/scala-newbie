

/**
 * Strategy one: construct a Rational from an Int
 * Can use an auxiliary constructor for this:
 * Check pdf auxiliary constructor highlighted
 */

class Rational(val n: Int, val d: Int){
  require(d != 0, "Zero Denominator")
  override def toString: String = s"R($n/$d)"

  def this(i: Int) = {
    this(i, 1)
  }

//  def this() = {
//    this(6)
//  }

  def +(other: Rational): Rational = {
  new Rational(
    this.n * other.d + this.d * other.n, // 1 + 25
    this.d * other.d // 5 * 1
  )
  }
}

val fifth = new Rational(1, 5)
val five = new Rational(5)
//val six = new Rational()
val sum = fifth + five // 1/5 , 5/1
val sumn = five + fifth // 5/1, 1/5

// Another example ------------------------------------------------------------

class Person(name: String, age: Int, city: String){ // module10.Person
  override def toString: String = s"$name, $age, $city"

  def this(name: String, age: Int) = { // Can be replaced using factory method
    this(name, age, "Srinagar") // B, call primary constructor module10.Person
  }

  def this(city: String) = { // C, calls B
    this("Fayaz", 28, city)
  }
}

val person = new Person("OBAID", 11, "SXR")
val person = new Person("Aamir", 12)
val person = new Person("Kashmir")
