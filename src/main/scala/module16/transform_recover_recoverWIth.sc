import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
val fAny: Future[Any] = Future{
  Thread.sleep(200)
  10
}
val future = fAny.collect{
  case i: Int => i
}

val failedFuture = fAny.collect{
  case i: Int => Future.failed(
    throw new ArithmeticException)
}

val res = future.transform(
  i =>
    i/0,
  ex =>
    throw new RuntimeException(ex.getMessage)
  )


//println(res)


/**val failedFuture = Future.failed(
  throw new RuntimeException("..---.."))*/
//failedFuture.fallbackTo(Future.successful(100))
// Create another Future and substitute this with failed one

// --------- Recover
// Recovering a failed future to a particular value
/** recover ---> (map of failure)
 * It takes a partial function from throwable => value.
 * Matches an exception and return default value.
 * */
Thread.sleep(300)
val recover = failedFuture.recover{
  case _: RuntimeException => 1234
}
println(recover)
Thread.sleep(2000)

// recoverWith
/** recoverWith ----> (flatMap over a failure)
 * It takes a partial function from throwable => new Future
 * Match an exception and substitute it with another Failure.
 * */

val recoverWith = failedFuture.recoverWith{
  case _: RuntimeException =>
    Future.successful(1)
}

Thread.sleep(200)
println(recoverWith)
Thread.sleep(20000)
