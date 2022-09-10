import scala.concurrent.{Await, Future}
import scala.concurrent.duration.DurationInt
import scala.util.Try
var time = 0
def resetTries(): Unit = time = 0
def calc(): Int = {
  if (time > 3) 10 else {
    time += 1
    throw new IllegalStateException("not yet")
  }
}
Try(calc()) // fail
Try(calc()) // fail
Try(calc()) // fail
Try(calc()) // fail
Try(calc()) // success(10)
resetTries() // back to not working

import scala.concurrent.ExecutionContext.Implicits.global


def fCalc(): Future[Int] = Future(calc())
val f2: Future[AnyVal] = fCalc().
  recover { case e => println(e.getMessage)}

val res = Await.result(f2, 100.seconds)