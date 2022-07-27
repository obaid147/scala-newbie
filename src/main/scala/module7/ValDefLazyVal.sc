class Demo{
  val a: Int = {
    println("Evaluating A")
    10
  }
  def b: Int = {
    println("Evaluating B")
    20
  }
  lazy val c: Int = {
    println("Evaluating C")
    30
  }
}

val demo = new Demo // evaluates a as its a val
demo.a // caches a and returns 10

demo.b // outputs b whenever we call it
demo.b // outputs b whenever we call it

demo.c // evaluating C is printed only once
// lazy val calculates if/when first used, then memorizes
demo.c
