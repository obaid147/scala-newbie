import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._
import scala.util.Try
/**The ExecutionContext is used to configure how and on which
thread pools asynchronous tasks (such as Futures) will run,
so the specific ExecutionContext that is selected is important.*/
//--------- Creating future using factory method, apply method.
val result = Future(10+2)
// running this without ExecutionContext Error.
// once a future has been resolved, it stays with that value.
result

// --- using {} braces
//put more stuff into the function we want to execute as a future.

val l = (0 to 179).toList
case class someLongCalculation(twenty: Int = 20)
case class someCalculation(a: someLongCalculation){
  def refineResult(): Int = l.length + a.twenty
}

// When we do this as below, it will run as a separate thread.
val futureResult = Future{
// this is a byName function that will get packaged up and
  // a new future will be created.
  val a: someLongCalculation = someLongCalculation()
  val b = someCalculation(a)
  b.refineResult()
  // within that future, within some other thread this code
  // gets executed
}
futureResult

// ----------------
// This doesn't spawn another thread.
// This gives us back an already resolved future
Future.successful(1+2)
/** We don't need execution context, it's not using separate thread.*/
Future.fromTry(Try(1/0))
//Future.failed(throw new ArithmeticException("/ by zero"))
/**
 * If we already have a result, we can create success or failure,
 * with above methods
 */
///////////// Try
 /** If we use Try, We can create a Future immediately
 * from that as well
 * */

