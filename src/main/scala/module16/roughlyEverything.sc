/**Future returns eventually*/
// 1 - the imports
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._
import scala.concurrent.duration._
import scala.util.{Failure, Success}

/**
  // 2 - create a Future
  val f = Future {
    Thread.sleep(500)
    1 + 1
  }

  // 3 - this is blocking (blocking is bad)
  val result = Await.result(f, 1.second) // This is bad use callback
  println(result)
  Thread.sleep(1000)

/**The import statements bring the code into scope that’s needed.*/
/*The ExecutionContext.Implicits.global import statement imports the “default global execution context.”
You can think of an execution context as being a thread pool, and this is a simple way to get access to a thread pool.
*/
/**A Future is created after the second comment. Creating a Future is simple; you just pass it a block of code you
want to run. This is the code that will be executed at some point in the future.**/
/*The Await.result method call declares that it will wait for up to one second for the Future to return.
If the Future does’t return within that time, it throws a java.util.concurrent.TimeoutException.*/
/**The sleep statement at the end of the code is used so the program will keep running while the Future is
being calculated. You won’t need sleep in real-world programs, but in small example programs like this,
you have to keep the JVM running.*/

// --- Run one thing, but don’t block, use CALLBACK methods (**onComplete)
val future = Future{Thread.sleep(100); 42}
println("before onComplete------")
future.onComplete{
  case Success(value) => println(s"$value")
  case Failure(e) => e.printStackTrace()
}
Thread.sleep(100)
println("Doing my work")
println("A ------")
Thread.sleep(100)
/**The future.onComplete method sets up the callback.
Whenever the Future completes,it makes a callback to onComplete, at which time that code will be executed.*/
//The Future will either return the desired result (42), or an exception.
/**The println statements with the slight delays represent (other work our code can do
while the Future is running.*/

// --- onSuccess and onFailure callback methods....// These methods are deprecated
//If we have a result, we can use Future.successful/failed
val f: Future[Int] = Future {
  Thread.sleep(Random.nextInt(500))
  if (Random.nextInt(500) > 250) throw new Exception("Yikes!") else 42
}
Future.successful(f)
//Future.failed(throw new Exception("Yikes!"))

Future.fromTry(Try(1/0))
// Create a new Future and returns Future(Failure/Success)

//---Creating a method to return a Future[T]

def longRunningComputation(i: Int): Future[Int] = Future{
  Thread.sleep(100)
  i + 1
}
// this code below does not block.
longRunningComputation(10).onComplete{
  case Success(value) => value
  case Failure(exception) => exception.printStackTrace()
}
// important: keep the jvm from shutting down
Thread.sleep(1000)

// ---------------------------
/**If i create a stock market application
 * I run all of my web service queries in parallel, wait for their results, and then display a web page.
 * This is faster than running them sequentially. */
*/
object Cloud{
  def runAlgorithm(i: Int): Future[Int] = Future{
    Thread.sleep(100)
    val result = i + 1
    println(s"returning result from cloud: $result")
    result
  }
}
println("Starting Futures -> for comprehension")
val result1: Future[Int] = Cloud.runAlgorithm(10)
val result2: Future[Int] = Cloud.runAlgorithm(20)
val result3: Future[Int] = Cloud.runAlgorithm(30)
Thread.sleep(1000)
val result: Future[Int] = for{
  r1 <- result1
  r2 <- result2
  r3 <- result3
} yield r1+r2+r3
println("--Before onComplete()")
// Here WHAT WE LEARNED, The callbacks should be interesting.
/** no success failure returned using onComplete.*/
//result.onComplete{
//  case Success(value) => value
//  case Failure(exception) => exception.printStackTrace()
//}

Thread.sleep(100)
val transformResult = result.transform{
  case Success(value) => Success(value)
  case Failure(e) => Failure(e)
}
transformResult
println("before sleep at the end")
Thread.sleep(2000)  // important: keep the jvm alive

//- ------ map
val f1: Future[Int] = Cloud.runAlgorithm(100)
val f2: Future[Int] = f1.map(_+10)
val mapTheFuture: Future[Int] = for {x <- f2} yield x + 200
Thread.sleep(100)
val tMap: Future[Int] = mapTheFuture.transform{
  case Success(value) => Success(value)
  case Failure(e) => Failure(e)
}
Thread.sleep(2000)
tMap
Thread.sleep(2000)  // important: keep the jvm alive
