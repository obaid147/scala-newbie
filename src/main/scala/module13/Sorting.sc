/*
case class Person(name: String, age: Int)
val xs = List(Person("Obaid", 28), Person("Shehzal", 3),
              Person("Amir", 31))

//xs.groupBy(Person => Person.age < 20)
xs.sortBy(_.name) // Sorted by Name Ascending order

xs.sortWith((p1, p2) => p1.age < p2. age)

List(4, 8, 3, 7, 5, 2, 0, 1).sorted

implicit object PersonOrdering extends Ordering[Person]{
  override def compare(x: Person, y: Person): Int = {
    if(x.name == y.name) x.age - y.age
    else if(x.name > y.name) 1
    else -1
  }
}
xs.sorted*/
//val x: Int = RichInt(10)
val list:List[Int] = List(11, 10, 1, 6)
list.sorted

case class Person(name: String, age: Int)
val xs = List(Person("Obaid", 28), Person("Shehzal", 3),
  Person("Amir", 31))

implicit object PersonOrdering extends Ordering[Person]{
  override def compare(x: Person, y: Person): Int = {
      x.age - y.age
  }
}

xs.sorted
xs.sortBy(_.name)
// sorted and sortBy uses implicits.

xs.sortWith((p1, p2) => p1.age < p2.age)
// sortWith does not use implicits.
