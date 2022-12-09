package module16

import scala.util.control.NonFatal
import scala.concurrent.ExecutionContext.Implicits.global


object RetryingMechanism1 extends App {

  import scala.concurrent.duration.DurationInt
  import scala.concurrent.{Await, Future}

  var time = 0
  //def resetTries(): Unit = time = 0
  def calc(): Int = {
    if (time > 3) 10 else {
      time += 1
      throw new IllegalStateException("not yet")
    }
  }

  def fCalc(): Future[Int] = Future(calc())

  val f3: Future[Int] = fCalc().
    recoverWith { case NonFatal(_) => fCalc() }.
    recoverWith { case NonFatal(_) => fCalc() }.
    recoverWith { case NonFatal(_) => fCalc() }.
    recoverWith { case NonFatal(_) => fCalc() }
  //Await.ready(f3, 10.seconds)

  val res: Any = Await.result(f3, 10.seconds)
  println(res)
}

object RetryingMechanism2 extends App {

  import scala.concurrent.duration.DurationInt
  import scala.concurrent.{Await, Future}
  import scala.concurrent.ExecutionContext.Implicits.global

  var time = 0

  def resetTries(): Unit = time = 0

  def calc(): Int = {
    if (time > 3) 10 else {
      time += 1
      throw new IllegalStateException("not yet")
    }
  }
  def retry[T](op: => T, retries: Int): Future[T] =
    Future(op) recoverWith {
      case NonFatal(_) if retries > 0 => retry(op, retries - 1)
    }

  resetTries()
  val f3 = retry(calc(), 3) // 4
  Await.ready(f3, 10.seconds) // failure
  println(f3)

  resetTries()

  val f4 = retry(calc(), 5)
  Await.ready(f4, 10.seconds)
  println(f4)

}
