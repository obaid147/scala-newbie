/**As we have already seen using foreach with multiple Futures
 * ComposingFuturesForMapFlatMap.sc
 *
 * This works as long as we know number of futures we have,
 * Example with multiple no. of futures.....
 ***** Future.sequence() function flips
 * Seq[Future[T]] TO Future[Seq[T]]. Without blocking.
 * Also works for Sets */
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._
import scala.concurrent.duration.DurationInt

val ints = (1 to 5).toList // suppose there are more numbers

def square(i: Int): Future[Int] = Future(i * i)

val mapOverList: List[Future[Int]] = ints.map(square)

val sequenceFun: Future[List[Int]] = Future.sequence(mapOverList)
val traverseFun: Future[List[Int]] = Future.traverse(ints)(square)//better
Await.ready(traverseFun, 1.second)
/******* Future.traverse()
 * A map over a Seq, followed by a Future.sequence
 * can be replaced by a Future.traverse */

  // SET example
val mySet = Set(1, 2, 3, 4, 5)
def isEven(i: Int): Future[Boolean] = Future(i % 2 == 0)

val mapOverSet: Set[Future[Boolean]] = mySet.map(isEven)

val setFun: Future[Set[Boolean]] = Future.sequence(mapOverSet)
val traverseSet: Future[Set[Boolean]] = Future.traverse(mySet)(isEven)//useThis
Await.ready(traverseSet, 1.second)


//--- Other FutureSequence Operations
val ft1 = Future { Thread.sleep(10); 10 }
val ft2 = Future { Thread.sleep(5); 5 }
val ft3 = Future { Thread.sleep(20); 20 }
val sft: List[Future[Int]] = List(ft1, ft2, ft3)

Await.ready(Future.firstCompletedOf(sft), 1.second) // Future(Success(5))
// Takes Seq[Futures[T]] First Seq to complete will be used as a result
/**Scala futures are non cancelable, this will not block next processing*/

Await.ready(Future.foldLeft(sft)(0)(_ + _), 1.second) // Future(Success(35))
Await.ready(Future.reduceLeft(sft)(_ + _), 1.second) // Future(Success(35))

/** We will do more foldLeft rather than reduceLeft because of empty Seq*
 * Future.foldLeft:-
 * It takes 0 as starting value and Seq[Futures] as a seq, Next
 * it takes a combiner function and does
 * 0+10, 10+5, 15+20 = 35 and returns Future(Success(35))
 * It does this without needing to block it.
 */
