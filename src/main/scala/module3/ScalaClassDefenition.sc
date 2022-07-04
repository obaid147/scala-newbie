/**
 * On the JVM, all methods/fields must go inside classes (unlike the REPL)
 * In Scala, this includes objects, traits, and package objects (more later)
 */

class DemoWithFieldsAndMethods {
  val x: Int = 10
  val y: Int = x * 2
  def timesY(a: Int): Int = a * y
}
val demoWithFieldsAndMethods = new DemoWithFieldsAndMethods
demoWithFieldsAndMethods.x
demoWithFieldsAndMethods.y
demoWithFieldsAndMethods.timesY(2)

class DemoWithParams(name: String) {
  println(s"Constructing for $name")

  def sayHi(times: Int): Unit = {
    var time = 0

    while (time < times) {
      println(s"Hi, $name")
      time += 1
    }
  }
}
val demoWithParams = new DemoWithParams("\'Obaid\'")
demoWithParams.sayHi(3)