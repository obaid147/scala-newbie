package module5

object ListWithComplexFunction extends App {

  val f: Int => Int = x => x + 2

  val l = (1 to 10).toList
  val r = l.map(f)

  println(r)

  val r2 = l.map { elem =>
    val x = elem  + 1
    f(x)
  }

  println(r2)

  val g: Int => Int = x => {
   val y =  x + 1
    f(y)
  }

  val r3 = l.map(g)
  println(r3)
}