import org.scalatest.{FunSuite, Matchers}

import scala.concurrent.Future


class FutureTest extends FunSuite with Matchers{
  import scala.concurrent.ExecutionContext.Implicits.global

  def calc(n: Int, iterations: Int): Future[Double] = Future{
    Thread.sleep(n)
    println(iterations, "-----------------------")
    n.toDouble
  }

  test("Calculating PI Asynchronously") {

    val calcPi = new FutureTest
    val resultF = calcPi.calc(500, 1000000)
    for (piBy4 <- resultF) yield {
      println(piBy4 * 4)
      piBy4 * 4 should be(10.0 +- 0.001)
    }
  }
}