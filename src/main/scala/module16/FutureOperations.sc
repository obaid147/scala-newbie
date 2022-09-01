import scala.concurrent._
import scala.concurrent.duration.DurationInt
import ExecutionContext.Implicits.global

//val fa: Future[Any] = Future(10)
// instead of being Option of value it is a future of value
// it may succeed or fail, but we are working without being blocked.

/**
 * Map will take a function from A to B and a future of A,
    and it will give you back a future of B without blocking.
 * Likewise, flat map will take function from A to A and a future of B
    and still give you back a future of B.
   flatMap collapses the 2 Futures into 1.
 */
//In addition to map and flatMap there are a number of other future operations:


val fa: Future[Any] = Future(10)
// We should get a more specific type

//We can use collect to turn back an Any to a more specific type
/** collect is a partial function which will attempt to narrow
 * the type if it can*/
val fi: Future[Int] = fa.collect{ // anything that has a case inside it is a partial function.
  case i: Int => i
}
// If fa has Int, fi will be any Future[Int] otherwise failed Future.

/** Now we know we either have an Int or a failure.
 * Failed case is handled by Future automatically.
 */


val fii = fi.filter(_ > 11) // failing inside filter
// This becomes a failure(failed[Future])

Await.ready(fi, 1.second)// Future(Success(10))

Await.ready(fii, 1.second)////Future.filter predicate is not satisfied

// Handling both success & failure in one method..................
  //   We can use transform that takes 2 functions

def handleSuccessFailed: Future[Int] = fii.transform(i => i * 5,{
    ex =>
    println(ex.getMessage)
    throw new RuntimeException("Failed at filter", ex)
})

Await.ready(handleSuccessFailed, 1.second)