import scala.concurrent._
import duration._
import ExecutionContext.Implicits.global

/**
 * For is more than just for looping
 * Future is a result that is happening concurrently
 * Inside for{} all generators must be of same type
 */
//val f1 = Future(1.0)
//val f2 = Future(2.0)
//val f3 = Future(3.0)
//val f4 = for { // f4 is now a future
//  v1 <- f1 // value 1 from future 1
//  v2 <- f2 // value 2 from future 2
//  v3 <- f3 // value 3 from future 3
//} yield v1 + v2 + v3
//Await.result(f4, 10.seconds)

/**
 * Easy asynchronous programming
 * Also Try, Option, Either, *your type here*
 * All you need is a type with foreach, map, flatMap,
   withFilter with the correct type signatures
 */