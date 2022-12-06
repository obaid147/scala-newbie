/**Probably the single most useful thing about Futures is that they compose with
    map and flatMap while remaining asynchronous.
 * flatMap also works asynchronously. Combining with for expressions is even cooler. */

import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.annotation.unused

val f1 = Future{
  Thread.sleep(1000)
  10
}

// Even before f1 is resolved, we can still work on it
// as it is not blocked
val f2: Future[Future[Int]] = Future(f1.map(_ * 10))
val f33: Future[Int] = f2.flatten
@unused
val f44: Future[Int] = f2.flatMap(x => x.map(y => y))
f1.value
f1.isCompleted
f33.value
f2.isCompleted

Thread.sleep(1000)

f1.value
f1.isCompleted
f33.value
f2.isCompleted
// The future don't block but we can still do work on them
// assuming we have a result even before we have that result.

// ---------------- using for expression,
// for expression is being converted into map flatMap
@unused
val x1: Option[Int] = for{
  i <- Option(1)
  j <- Option(2)
  k <- Option(3)
} yield i+j+k
// is same as
@unused
val x2: Option[Int] = Option(1).flatMap(i => Option(2).flatMap(j => Option(3).map(k => i+j+k)))
// ---------------- using for expression with Futures
val a = 1
// if 'a' was some db conn, compiler will wait for it to complete
val b = 2
// if 'b' was some response from as service, compiler will also wait for it to complete
val c = 3 // 'c' was something compiler is waiting
val s = "The Simple answer is:- "
val sum = a + b + c
s"$s $sum"
// compiler will wait for all 'a b c & s' to complete to return s"..."

val fa = Future(1)
val fb = Future(2)
val fc = Future(3)
val fd = Future("The Future answer is:-")

val fRes = for{
  i <- fa
  j <- fb
  k <- fc
  s <- fd
}yield{
  val sum = i+j+k
  s"$s $sum"
}
fRes
// We can use this feature turning async code to sync code.

// ----------------------- Async Evaluation
/**
 * The longest delay in any of our threads is 1 second.fx
 * The second delay is half second.fz
 * Instead of taking 1.5 seconds, to eval everything, It is going to
    take only 1 second because these Futures are created in parallel.
 * So, when fx will be ready, all other futures will also be ready.
 */
val fw = Future(1)
val fx = Future{
  Thread.sleep(1000)
  2
}
// in fx the longest delay
val fy = Future(3)
val fz = Future{
  Thread.sleep(500)
  "The result is:- "
}

val futureResults = for{
  i <- fw
  j <- fx
  k <- fy
  l <- fz
} yield {
  val sum = i+j+k
  s"$l $sum"
}
futureResults.value
futureResults.isCompleted
Thread.sleep(1000)
futureResults.value
futureResults.isCompleted
