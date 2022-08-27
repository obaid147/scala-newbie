case class Person(name: String, age: Int)

import java.util.{Arrays, Comparator}

val javaArray = Array(module10.Person("A", 1), module10.Person("B", 2), module10.Person("C", 3))

//The old single abstract method way
implicit val comp1 = new Comparator[module10.Person] {
  override def compare(o1: module10.Person, o2: module10.Person): Int = o1.age - o2.age
}

Arrays.sort(javaArray, comp1)

// with implicit
implicitly[Comparator[module10.Person]].compare(
  module10.Person("q",10), module10.Person("z", 2)
)

// without implicit
comp1.compare(module10.Person("q",10), module10.Person("z", 2))

javaArray

// the new java lambda way
Arrays.sort(javaArray,
  (p1: module10.Person, p2: module10.Person) => p2.age - p1.age)

javaArray