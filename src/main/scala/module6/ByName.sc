import scala.language.implicitConversions

def byNameMethod(f: => Unit):Unit = {
  println("inside method")
  f
}

byNameMethod(println("hi"))

case class Person(name: String) {
  def fullName = name + " fayaz"
}

implicit def method(s: String): Person = {
  Person(s)
}

val n = Person("ml")
n.fullName

Person("obaid").fullName

"aamir".fullName

