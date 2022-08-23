import scala.concurrent.Future
//import ExecutionContext.Implicits.global
import org.scalatest.{Matchers, FunSuite}


abstract class CalcPi extends Matchers with FunSuite {
  def calc(n: Int, iterations: Int): Future[Double] = {
    ???
  }

  test("Calculating PI Asynchronously") {
    val calcPi = new CalcPi
    val resultF = calcPi.calc(500, 1000000)
    for (piBy4 <- resultF) yield {
      println(piBy4 * 4)
      piBy4 * 4 should be(10.0 +- 0.001)
    }
  }
}