/**
 * implicit keyword on method --> on def , discouraged(src/main/scala/untitled.sc)
 * implicit classes --> to get extension methods--
      module8/implicitClasses.sc(vowelsExample)
 * implicit Variables.
 */

// ---------------------------- implicit Variables.
object ImplicitVariables1 extends App {
  val value = 10
   implicit val multiplier: Int = 3

  def multiply(implicit by: Int): Int = value * by

  // implicit resolution = search for an implicit value, found and then injected
  val result = multiply

  println(result)
}

object ImplicitVariables2 extends App {

   val a = 10
  implicit val b: Int = 20
  //def add(implicit a: Int, b: Int) = a + b ;; CTE implicit parameter must be last one

  // def add(a: Int, implicit b: Int) = a + b ;; CTE, syntactically not correct
    def add(a: Int)(implicit b: Int): Int = a + b
   println {
     add(a)
   }
}
object ImplicitVariables3 extends App {

  implicit val a: Int = 10
  implicit val b: Int = 20
  //def add(implicit a: Int, b: Int) = a + b ;; CTE implicit parameter must be last one

  // def add(a: Int, implicit b: Int) = a + b ;; CTE, syntactically not correct
  def add(a: Int)(implicit b: Int): Int = a + b
  println {
   // add(a) CTE: ambiguous implicit values:
  }

}
object ImplicitVariables4 extends App {

  import scala.concurrent.Future
  import scala.concurrent.ExecutionContext.Implicits.global // Future's apply method uses implicits.
  //implicit variable must be in scope here
  val x: Future[Int] = Future(10)
}
