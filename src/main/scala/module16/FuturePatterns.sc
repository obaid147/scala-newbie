import scala.concurrent._
import ExecutionContext.Implicits.global

// --------------Future Batching
def calc(i: Int): Future[Int] = Future{
  println(s"Calculating for $i")
  Thread.sleep(1000)
  i*i
}
def processSeq(xs: Vector[Int]): Future[Vector[Int]] = {
  val allFutures: Vector[Future[Int]] = xs.map(calc)
  Future.sequence(allFutures)
}
/**Scala's Execution Context will prevent too many threads
  running at once
 * But you can still overwhelm other resources,
                    or run out of memory, etc.
 * Need a way to batch up Futures into GROUPS*/

// ------------Future Batching- fold Left and flatMap

/**Combining foldLeft and flatMap makes this fairly easy. */
def processSeqBatch(xs: Vector[Int], batchSize: Int):
Future[Vector[Int]] = {
  val batches = xs.grouped(batchSize) // 2's
  val start = Future.successful(Vector.empty[Int])

  batches.foldLeft(start) {(accF, batch) =>
    for {
      acc <- accF
      batchRes <- processSeq(batch)
    } yield acc ++ batchRes
  }
}
val p = processSeqBatch(Vector(1,2,3,4), 2)
p.isCompleted
p.value
Thread.sleep(500)
p.isCompleted
p.value











