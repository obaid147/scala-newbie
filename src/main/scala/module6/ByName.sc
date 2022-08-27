import scala.language.implicitConversions

def byNameMethod(f: => Unit):Unit = {
  println("inside method")
  f
}

byNameMethod(println("hi"))

case class Person(name: String) {
  def fullName = name + " fayaz"
}

implicit def method(s: String): module10.Person = {
  module10.Person(s)
}

val n = module10.Person("ml")
n.fullName

module10.Person("obaid").fullName

"aamir".fullName

