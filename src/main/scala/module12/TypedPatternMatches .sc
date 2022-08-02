case class Person()

def describeType(x: Any) = x match {
  case i: Int => i
  case d: Double => d
  case s: String => s
  case c: Char => c
  case p: Person => p
  case _ => "Some other type"
}

describeType(1)
describeType(1.1)
describeType("Obaid")
describeType('O')
describeType("O")
describeType(Person)
describeType(true)

// Once matched, the variable is typed on both the left and right of the =>
// This is idiomatic and favored over the form:
val s: Any = "Hello"
if(s.isInstanceOf[String]) {
  s.asInstanceOf[String].reverse
}