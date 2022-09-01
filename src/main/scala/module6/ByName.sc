import scala.language.implicitConversions

// check module6.WritingOurOwnLoop.sc
def byValue(i: Int): Unit = {
  println(s"First = $i")
  println(s"2nd = $i")
  println(s"3rd = $i")
}
byValue(1)

def byName(i: => Int): Unit = {
  println(s"First = $i")
  println(s"2nd = $i")
  println(s"3rd = $i")
}
var total = 0
byName{
  total += 1
  total
}

/**byNameMethod will print  inside method then hi
 * if there was no =>, It will print hi then inside method */
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


