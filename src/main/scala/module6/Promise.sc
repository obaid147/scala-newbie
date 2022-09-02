import scala.concurrent.{Future, Promise}

/*The Promise is a writable, single-assignment container that completes a Future.
The Promise is similar to the Future. However, the Future is about the read-side
of an asynchronous operation, while the Promise is about the write-side.*/
/** The Promise is a write handle to a value that will be available at
 * some point in the future. It allows us to put the value of a completed
 * asynchronous operation into the Future, and change the state of the Future
 * from not completed to completed by invoking the success method.
 * Once the Promise is completed, we cannot call the success() method again. */

/**
 * Future is the client end of the operation that hasn't yet been completed.
 * Producing the client is the server side part of the Future and that is called the promise.
 * Promise is also a non blocking operation.
 * When we create a promise of some type, that promise is like a server side channel
    for a result to go into at some point in the future. And when you do push a result into it,
    the result will come out of the future, which we passed back to the client.
 */

// From a promise, we can take the future and hand that back.
/**The server hangs onto the promise, does some calculation,
    and once the calculation is complete, it pushes something into the promise.*/

val promise: Promise[Int] = Promise[Int] // new Promise[type]
// Promise[Int] is a case class with comp obj in fact()
val future: Future[Int] = promise.future
  // getting back client side handle

// client side is not complete
future.isCompleted
future.value

// when using success or failure, the future connected to it
// will be completed.

promise.success(10)

// client side will complete after we call promise.s or promise.f
future.isCompleted
future.value

//// Broken Promise
val promise1 = Promise[Int]
val future1 = promise1.future

future1.isCompleted
future1.value

promise1.failure(new IllegalStateException("oops!"))

future1.isCompleted
future1.value

/**
 * A promise is the "server" to the "client's" Future
 * By creating a Promise you create a socket into which you
    can send something.
 * You can also obtain the Future from the Promise and hand that to
    someone else.
 * When you put the value (or failure) into the Promise, the Future
    is resolved with that outcome
 */