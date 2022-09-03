/**a Future is a placeholder to hold a computation unit
 * (which returns a value or exception that does not exist yet).
 *
 * Promise is an object used to write AP. It is used to execute asynchronous code.
 *
 * Future is used to read that result.
 * Promise is used to finish that computation and write a value into.
 */

import scala.concurrent.Promise
val promise = Promise[Int]
//Creates a promise object which can be completed with a value.
val future = promise.future
future.isCompleted
future.value
/**You can also obtain the Future from the Promise and hand that to someone
else
When you put the value (or failure) into the Promise, the Future is resolved
with that outcome
*/
promise.success(20)
future.isCompleted
future.value

// ------------- A Broken Promise
val promise = Promise[String]
val future = promise.future
future.isCompleted
future.value
promise.failure(new StringIndexOutOfBoundsException("Oops!!!"))
//A Promise allows you to easily adapt another
// asynchronous event into a Scala Future
future.isCompleted
future.value
