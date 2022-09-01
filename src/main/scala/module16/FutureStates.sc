/**
 * when you create a future, it starts running immediately,
 * it also returns a handle absolutely immediately,
 * no matter how long the future takes.
 */

/** Different states of the future
 * How they work to not block the thread we are on while
 * still doing work and giving back a handle with a
 * future result in it.
 */
import scala.concurrent._
import ExecutionContext.Implicits.global // global is a thread pool
//for demo purposes also I am allowed to use Await and Thread.sleep()
val f1 = Future{ //
  Thread.sleep(1000)
  10
}
/** INCOMPLETE STATE (unresolved)*/
f1.value // Option[scala.util.Try[Int]] = None
f1.isCompleted // false

Thread.sleep(1000)
/** COMPLETE STATE with SUCCESS (resolved successfully)*/
f1.value // as soon as it is complete, we get success
f1.isCompleted // true

/** COMPLETE STATE with FAILURE (resolved unsuccessfully)*/
val f2 = Future(1/0)
Thread.sleep(10)
f2.value
// -----------------
println("-"*50)



val future1 = Future{Thread.sleep(1000); 10}
val future2 = Future(future1.map(_*10))
//These come back immediately even when using map or flatMap

