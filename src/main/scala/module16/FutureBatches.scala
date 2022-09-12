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

  val nums = (1 to 20).toVector
  val f1 = processSeq(nums)
  val result1 =  Await.result(f1, 20.seconds) // starts all 20 at once
  println("---------------------")
  val f2 = processSeqBatch(nums, 2)
  val result2 =  Await.result(f2, 20.seconds)
  // waits for each 2 to finish before starting next

  println(result1)
  println(result2)
}
