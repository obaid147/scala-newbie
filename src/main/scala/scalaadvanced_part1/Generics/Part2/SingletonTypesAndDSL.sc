import scala.language.postfixOps

/**Every Scala instance has a unique type member associated with it: .type */
val s = "hey"
def sayHey(str: s.type) = str // s.type is SINGLETON type of s.
/**sayHey() can now only take the specific instance s as an argument, e.g.:*/
sayHey(s)
//sayHey("hi") // TYPE MISMATCH
/**
This is often useful for DSLs (Domain Specific Languages) and some other advanced
uses.
It's also how you can refer to the type of a singleton object in Scala*/

// --------------------- DSL (Domain specific language)

/** DSL that uses singleton types*/
val or = "or"
val to = "to"

object To {
  def be(o: or.type) = this
  def not(t: to.type) = this
  def be = "That is the question" // diff type signature, be without params
}
//To.be(or).not(to).be
To be or not to be

To not to be or be

