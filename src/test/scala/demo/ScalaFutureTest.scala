object HelloWorld {
  import scala.concurrent.ExecutionContext.Implicits.global
  import scala.concurrent.Future
  val theOneWhoCannotBeNamed = "Voldemort"

  def sayHelloTo(name: String): Future[Option[String]] = {
    Future {
      if (theOneWhoCannotBeNamed.equals(name)) None else Some(getHelloMessage(name))
    }
  }

  def getHelloMessage(name: String): String = {
    s"Hello $name, welcome to the future world!"
  }
}
/**The code above is pretty straightforward and provides a function that
 * receives a name and returns an Option[String] with a message wrapped in a Future object.
 * If the input name is “The One Who Cannot Be Named”,
 * then it just returns None, otherwise a welcome message is returned.

 * It’s important to remember that in order to create a Future, you need to inform an ExecutionContext,
 * and that can be done either explicitly or implicitly. In our case, we chose the latter option,
 * by using the implicit ExecutionContext provided by scala.concurrent.ExecutionContext.Implicits.global.*/

// -----------------  Scala Test
/**ScalaTest is a testing framework for the Scala ecosystem that provides a lot of nice features and flexibility.
 * One cool thing is that it allows us to write our tests in a variety of different styles,
 * such as TDD and BDD. Take a look here to see them all.*/

// There are a few ways we can test our HelloWorld object.

import org.scalatest.{FunSuite, Matchers}

import scala.concurrent.Await
import scala.concurrent.duration.DurationInt
// last statement of each test should return Assertion
class HelloWorldSpecWithAwait extends FunSuite with Matchers{

  test("A valid message should be returned to a valid name(Await)"){
    val result = Await.result(HelloWorld.sayHelloTo("Harry"), 500.millis)
    result should be (Some("Hello Harry, welcome to the future world!"))
  }
  test("No message should be returned to the one who cannot be named(Await)"){
    val result = Await.result(HelloWorld.sayHelloTo("Voldemort"), 500.millis)
    result should be (None)
  }
}

/**Using Await, we explicitly wait until the Future is ready and then assert its result.
 *  While this works, it does not look very clean, so let’s look into whenReady.
 *
 *  The whenReady function receives a Future and wait until it’s completed,
 *  then we can extract its result and use it in any type of assertion we want to.*/

import org.scalatest.concurrent.PatienceConfiguration.{Interval, Timeout}
import org.scalatest.concurrent.ScalaFutures
// Last statement of each test should return Assertion....
class HelloWorldSpecWithScalaFutures extends FunSuite with Matchers with ScalaFutures {
  test("A valid message should be returned to a valid name(whenReady)") {
    whenReady(HelloWorld.sayHelloTo("Harry")){ res =>
      res should be(Some("Hello Harry, welcome to the future world!"))
    }
  }
  test("No message should be returned to the one who cannot be named(whenReady)") {
    whenReady(HelloWorld.sayHelloTo("Voldemort")){ res =>
      res should be(None)
    }
  }

  /** Internally, whenReady has 2 configurations:
   *
   *  timeout: Maximum time to wait until the Future is completed. Its default value is 150ms.
   *  If it’s not completed within this time, a TestFailedException will be thrown.

   *  interval: The interval used to keep pooling the Future object to know if it’s been completed or not.
   *  Its default value is 15ms.*/
  test("A valid message should be returned to a valid name(whenReady)") {
    whenReady(HelloWorld.sayHelloTo("Harry"), Timeout(2.seconds), Interval(500.millis)) { res =>
      res should be(Some("Hello Harry, welcome to the future world!"))
    }
  }
}
// We can create an implicit value of type PatienceConfig and that will be applied to all calls of whenReady:
// implicit override val patienceConfig = PatienceConfig(timeout = Span(2, Seconds), interval = Span(20, Millis))

/** In scala 3, for each suite, Async suite for Futures is provided by scala. like FunSuite -> AsyncFunSuite
 * where each test returns a Future[Assertion]*/

import org.scalatest.AsyncFunSuite
class HelloWorldAsyncSpec extends AsyncFunSuite with Matchers{

  test("A valid message should be returned to a valid name(Async)") {
    for{
      resF <- HelloWorld.sayHelloTo("Harry")
    } yield {
      resF should be (Some("Hello Harry, welcome to the future world!"))
    }
  }

  test("No message should be returned to the one who cannot be named(Async1)") {
    HelloWorld.sayHelloTo("Voldemort") map { result =>
      result shouldBe None
    }
  }

  test("No message should be returned to the one who cannot be named(Async2)"){
    for{
      res <- HelloWorld.sayHelloTo("voldemort")
    } yield res should be (None)
  }

}


