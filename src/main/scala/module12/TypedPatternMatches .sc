def api: Any = 10

//anti-pattern
if(api.isInstanceOf[String]) {
  val res = api.asInstanceOf[String]
  res
} else "casting failed"

api match {
  case i: String => i
  case i: Int => i.toString
  case _ => " unknown type"
}


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
s match {
  case str: String =>
    str.reverse
  case _ =>
}
if(s.isInstanceOf[String]) {
  s.asInstanceOf[String].reverse
}

// commits
1.Instead of IsInstanceOf asInstanceOf use pattern matching in type pattern matches.
2.Notes.txt with keywords
3.MatchingTry, wrapping a type with Try and wrapping try with Option, toOption
4.Reverse a list using tail recursion
5.Type Erasure,  at run time, only the class exists, not its type parameters.
This means that the runtime type of List[Int] and List[String] is actually the same.