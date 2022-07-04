/**
 * Constructor parameters are private (actually private[this]), also vals
 * private and protected are keywords, there is no public keyword, that's the default for vals
   and defs (but not for constructor parameters)
 * Adding a val keyword before the parameter definition makes it a public parametric field:
 */
class DemoWithParams(val name: String) {
  println(s"Constructing for $name")
}
val demo = new DemoWithParams(name = "Jill")
demo.name // Jill

/**Parametric fields are idiomatic Scala (remember they are vals)*/

// how Scala re-writes the above:
class DemoWithParams(_name: String) { // parameter still private[this]
  val name: String = _name // the public field definition
  println(s"constructing for $name")
}