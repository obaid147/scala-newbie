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

  def processSeqBatch(xs: Vector[Int], batchSize: Int): Future[Vector[Int]] = {
    val batches: Iterator[Vector[Int]] = xs.grouped(batchSize)
    val start: Future[Vector[Int]] = Future.successful(Vector.empty[Int])

    batches.foldLeft(start) {(accF, batch) =>
      for{
        acc: Vector[Int] <- accF
        batchRes: Vector[Int] <- processSeq(batch)
      } yield acc ++ batchRes
    }
  }

}

object FutureBatches extends App {


  import FutureBatchesUtil._

  val nums = (1 to 4).toVector
  val f = processSeq(nums)
  val result =  Await.result(f, 20.seconds)
  println(result)
}
