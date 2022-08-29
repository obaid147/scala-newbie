case class Person(name: String, age: Int)

import java.util.{Arrays, Comparator}

val javaArray = Array(Person("A", 1), Person("B", 2), Person("C", 3))

//The old single abstract method way
implicit val comp1 = new Comparator[Person] {
  override def compare(o1: Person, o2: Person): Int = o1.age - o2.age
}

Arrays.sort(javaArray, comp1)

// with implicit
implicitly[Comparator[Person]].compare(
  Person("q",10), Person("z", 2)
)

// without implicit
comp1.compare(Person("q",10), Person("z", 2))

javaArray

// the new java lambda way
Arrays.sort(javaArray,
  (p1: Person, p2: Person) => p2.age - p1.age)

javaArray