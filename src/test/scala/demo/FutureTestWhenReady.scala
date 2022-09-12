
import scala.concurrent.Future
class ReturnFuture{
  import scala.concurrent.ExecutionContext.Implicits.global
  def myInt: Future[Int] = Future{
    Thread.sleep(200)
    10
  }
}

import org.scalatest.concurrent.ScalaFutures
import org.scalatest.{FunSuite, Matchers}
class WhenReadyTest extends FunSuite with Matchers with ScalaFutures{
  // scalaFutures bring
  test("Int when ready"){
    val obj = new ReturnFuture
    val resF1 = obj.myInt

    /*import org.scalatest.AsyncFunSuite
    resF.map{ res =>
      res * 4 should be(10)
    }// here AsyncFunSuite*/


    import org.scalatest.concurrent.PatienceConfiguration.Timeout

    import scala.concurrent.duration.DurationInt
//    whenReady(resF1, Timeout(1.minute)) { result =>
//      //      result * 4 should be (40) // pass
//      result * 4 should be(10) // fails
//    }
      //       OR we can do this
    val resF2 = obj.myInt.futureValue(Timeout(1.minute))
    resF2 should be (10)


  }
}