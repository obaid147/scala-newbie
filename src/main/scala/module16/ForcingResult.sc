import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.concurrent.duration.DurationInt
/**
 * Using for and other combinators you can avoid blocking in almost all
circumstances, but eventually you will need to get the answer. Use
Await.result or Await.ready for this.*/

val success = Future(2 / 1)
val failure = Future(1 / 0)

Await.ready(failure, 1.second)
/**Await.ready waits for the Future to be resolved one way or the
other before continuing, but does not evaluate the result.*/
failure.value
failure.isCompleted

/** If you used Await.result in this example, an Exception would be thrown at that point.
 * */
Await.result(failure, 1.second)