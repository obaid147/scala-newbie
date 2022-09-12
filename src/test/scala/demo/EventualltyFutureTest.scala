import org.scalatest.FunSuite
import org.scalatest.concurrent.Eventually

import scala.util.Success

class FutureOfInt{
  import scala.concurrent.ExecutionContext.Implicits.global
  import scala.concurrent.Future
  def futureOfInt: Future[Int] = Future{
    2
  }
}

class EventualltyFutureTest extends FunSuite with Eventually{
  val obj = new FutureOfInt
  val resF = obj.futureOfInt

  test(""){
    eventually{
      assert(resF.value.contains(Success(2)))
//      assert(resF.value.contains(Failure(throw new Exception("--------------------------------"))))

    }
  }
}