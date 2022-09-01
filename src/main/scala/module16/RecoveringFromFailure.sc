import scala.concurrent._
import ExecutionContext.Implicits.global

val failedFuture1 = Future.failed(new RuntimeException("nah"))
// no ExecutionContext required
failedFuture1.fallbackTo(Future.successful(0))
/**In case of failed future create another Future as substitute*/

// or
val failedFuture2 = Future.failed(new IllegalArgumentException("nope!"))
val futureRecover = failedFuture2.recover{
  case _: IllegalArgumentException => 22 // takes PF
}
// If failed recover it to a particular value

val failedFuture3 = Future.failed(new IllegalStateException("nope Again!"))
val futureRecoverWith = failedFuture3.recoverWith{
  case _: IllegalStateException => Future.successful(22) // takes PF
}
