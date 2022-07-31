// In Scala, == is aliased to call .equals and is marked final.
// The equals and hashCode contract are hard to get right
// and defaults are not useful.

class Person(firstName: String, lastName: String, age: Int)

val p1 = new Person("Obaid", "Fayaz", 28)
val p2 = new Person("Obaid", "Fayaz", 28)
val p3 = p1

p1 == p2
p1.equals(p2)

p1.eq(p3) // compare instance
p2.eq(p3)

p1.##  // We get different hashCode for p1 and p2
p2.##
// So we will usually need to provide better equals/hashCode
// if we want to use these in collections, etc.

//OPTION 1 use Alt + Insert

// Option 2
class Fruit(val name: String) {
  def canEqual(other: Any): Boolean = other.isInstanceOf[Fruit]

  override def equals(other: Any): Boolean = other match{
    case that: Fruit =>
      (that canEqual this) &&
      name == that.name
    case _ => false
  }

  override def hashCode(): Int = name.hashCode
}

val f1 = new Fruit("Obaid")
val f2 = new Fruit("Obaid")
f1.canEqual(new Fruit(f2.name))
f1.equals(f2)
f1.hashCode() // we get same hashCode here
f2.hashCode()
//////////////////////////////////////////
class Apple(val brand: String, val color: String) extends Fruit("apple") {
  override def canEqual(other: Any): Boolean = other.isInstanceOf[Apple]
  override def equals(other: Any): Boolean = other match {
    case that: Apple =>
      super.equals(that) &&
        (that canEqual this) &&
        brand == that.brand &&
        color == that.color
    case _ => false
  }
  override def hashCode(): Int = {
    41 * (
      41 * (
        41 + super.hashCode
        ) + brand.hashCode
      ) + color.hashCode
  }
}

val a1 = new Apple("Apple", "Red")
val a2 = new Apple("Apple", "Red")

a1.hashCode() // same hashCode here
a2.hashCode()

/// WE CAN SIMPLY use CASE CLASS
case class Human(firstName: String, age: Int)
val h1 =  Human("Obaid", 28)
val h2 =  Human("Obaid", 28)
h1.## // same hashCode
h2.##
h1.hashCode()
h2.hashCode()