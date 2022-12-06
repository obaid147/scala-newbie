import scala.concurrent._
import scala.concurrent.duration.DurationInt
import scala.util.control.NonFatal

val p = Promise[Int]
/**Future containing the value of this promise 'p'.
 * Promise is a writable, single-assignment container that completes a Future.*/
val f: Future[Int] = p.future

val x = p.success(10)
p.future.value

//val result = Await.result(f, 10.seconds)

//import scala.concurrent.ExecutionContext.Implicits.global
def runByPromise[T](fn: => T)/*(implicit ec: ExecutionContext)*/: Future[T] = {
  val p = Promise[T]
//  ec.execute { () =>
    try {
      p.success(fn)
    } catch {
      case NonFatal(e) => p.failure(e)
    }
//  }
  p.future
}

val f: Int => Int = (x: Int) => {
  println("executing block")
  x / 5
}
//import scala.concurrent.ExecutionContext.Implicits.global
val f1  = runByPromise(f)
val result = Await.result(f1, 10.seconds)
result(10)
// next FutureBatches.scala
