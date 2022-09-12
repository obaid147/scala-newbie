import org.scalatest.concurrent.ScalaFutures.whenReady
import org.scalatest.{FunSuite, Matchers}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, Future}

class CalcPi {


  // Make this return a Future[Double] so that these draws can run in parallel
  def calc(): Future[Double] = Future {
    Thread.sleep(300)
    0.785
  }
}

class TestThem extends FunSuite with Matchers{
  test("Async pi calculation that should not pass but passes"){
    val calcPi = new CalcPi
    val resultF: Future[Double] = calcPi.calc()
// this passes because the main thread ends before the future is completed.
    for{
      piBy4 <- resultF
    } yield{
      println(piBy4*4)
      piBy4*4 should be  (10.0 +- 0.001)
    }
  }

  test("Asynchronous calculation of Pi_One"){
    val calcPi = new CalcPi
    val resultF: Future[Double] = calcPi.calc()
    val piBy4 = Await.result(resultF, 1.minute) // awaiting result of piBy4(BAD)

    println(piBy4 * 4)
    piBy4 * 4 should be(10.0 +- 0.001) // will not match and fail
  }

  test("Asynchronous calculation of Pi_Two") {
    val calcPi = new CalcPi
    val resultF: Future[Double] = calcPi.calc()
    val piBy4 = Await.result(resultF, 1.minute) // awaiting result of piBy4(BAD)

    println(piBy4 * 4)
    piBy4 * 4 should be (3.141 +- 0.001)
    
  }
  test("Asynchronous calculation whenReady") {
    val calcPi = new CalcPi
    val resultF: Future[Double] = calcPi.calc()
    import org.scalatest.concurrent._
    import PatienceConfiguration._

    whenReady(resultF, Timeout(1.minute)) { result =>
      result * 4 should be(3.141 +- 0.001)
    }
  }
}

object TestingFutures extends App {
  val c = new CalcPi
  val res = c.calc()
  println(s"My result is ----- ${Await.result(res, 2.second)}")
  Thread.sleep(300)
}