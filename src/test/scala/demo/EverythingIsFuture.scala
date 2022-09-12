import org.scalatest.{AsyncFunSuite, Matchers}

class CalcPiFuture {
  import scala.concurrent.Future
  import scala.concurrent.ExecutionContext.Implicits.global
  // Make this return a Future[Double] so that these draws can run in parallel
  def calc(): Future[Double] = Future {
    Thread.sleep(300)
    0.785
  }
}

class TestingEverythingAsFuture extends AsyncFunSuite with Matchers{
  import scala.concurrent.Future
  test("Extending AsyncFunSuite for the Future test") {
    val calcPi = new CalcPi
    val resultF: Future[Double] = calcPi.calc()
    resultF.map(x => x * 4)

    for {
      result <- resultF
    } yield{
      result * 4 should be(3.141 +- 0.001)
    }
  }
}

object EverythingIsFuture extends App {
  import scala.concurrent.Await
  import scala.concurrent.duration.DurationInt
  val c = new CalcPi
  val res = c.calc()
  println(s"My result is ----- ${Await.result(res, 2.second)}")
  Thread.sleep(300)
}

/*Async tests must result in a Future (so use for...yield usually).
While writing the tests you can end with succeed to stop everything
turning red*/