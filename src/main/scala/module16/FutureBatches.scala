package module16

import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, Future}

object FutureBatchesUtil {
  import scala.concurrent.ExecutionContext.Implicits.global

  def calc(i: Int): Future[Int] = Future {
    println(s"Calculating for $i")
    Thread.sleep(500)
    i * i
  }

  def processSeq(xs: Vector[Int]): Future[Vector[Int]] = {
//    val all = Future.traverse(xs)(calc)
    val allFutures: Vector[Future[Int]] = xs.map(calc)
    Future.sequence(allFutures)
  }
}
object FutureBatches extends App {


  import FutureBatchesUtil._

  val nums = (1 to 20).toVector
  val f = processSeq(nums)
  val result =  Await.result(f, 20.seconds)
  println(result)
}
