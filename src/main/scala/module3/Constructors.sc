class DemoWithParams(name: String) {
  println(s"Constructing for $name")
}
// rest of class...
/**
 * Parameters on the class definition become primary constructor parameters
 * Code in the class (not in defs) becomes the primary constructor code, runs when a new instance is constructed
 * Can't access the constructor parameters from outside because they are (private)
 */

//val demo = new DemoWithParams("Jill")
//demo.name
//// Error:(33, 83) value name is not a member of DemoWithParams


class A(a: Int){
  /**
   * Parameters on the class can be accessed inside the class
   * use val for parameter to make them public
   */
  println(a)
  def x() = println(a)
}
//def y() = println(a)

class B(var n: Int)

val x = new B(10)
x.n = 100
x.n