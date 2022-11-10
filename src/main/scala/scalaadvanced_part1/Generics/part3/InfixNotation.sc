val s = "hey"
s.charAt(1)
/*Infix can be used for any instance method with a single parameter, e.g.*/
s charAt 2

5.+(5)
5 + 5

/**This can be used for any item.method(singleParam)
 * and is particularly effective with symbolic methods*/


//Infix type Notation only works for types with 2 parameters****
case class Person(person1: String)


class Loves[T1, T2] {
  def describe(i1: T1, i2: T2) = s"$i1 loves $i2"
}
case class NamedLove(p1: String, p2: String)
  extends Loves[String, String]{
  def sayIt(): String = describe(p1, p2)
}
NamedLove("p1", "p2").sayIt()

/**NamedLove can be written as*/
case class NamedLoveInfix(p1: Person, p2: Person)
  extends (Person Loves Person) {
  def sayIt(): String = describe(p1, p2)
}
NamedLoveInfix(Person("1"), Person("2")).sayIt()


def sayItWithRoses(lovers: Person Loves Person): String = {
  lovers.describe(Person("1"), Person("2"))
}
sayItWithRoses(NamedLoveInfix(Person("1"), Person("2")))