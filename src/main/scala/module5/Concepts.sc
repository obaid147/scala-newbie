abstract class Animal{
  def name: String
  def combineNames(firstName: String, lastName: String): String
  def apply(firstName: String, lastName: String): String
}

//anonymous class
val animalObject = new Animal() {
  override def name = "abc"
  override def combineNames(firstName: String, lastName: String): String = firstName + lastName
  override def apply(firstName: String, lastName: String): String = {
    firstName + lastName
  }
}
animalObject("abc", "def") // apply()
animalObject.combineNames("ghi", "jkl")
/*
abstract class Vehicle {
  def name: String
}

class Car extends Vehicle {
  override def name = "ferrari"
}*/


trait MyFunction {
  def apply(x: Int): String
}

val f1 = new MyFunction() {
  override def apply(x: Int) = x + 1 + ""
}
f1(1)

//takes Int returns String
val ff: Int => String = x => x + 1 + ""

//       takes Int returns String
val gg: Function1[Int, String] = x => {
  //    Int => String = x => x + 1 + ""
  x + 1 + ""
}
ff(10)
gg(10)
///-------------- Takes 2 Ints and returns Int
val xs: Function2[Int, Int, Int] = (x, y) => x + y
xs(10, 20)

val xs2: (Int, Int) => Boolean = (x, y) => (x * y) == 200
xs2(10, 20)


val print: Seq[Int] = for (i <- 1 to 5) yield i
for (j <- print) println(j)