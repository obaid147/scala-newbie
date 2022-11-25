//Let's consider this on a conceptual Future:


/*
def flatten[F](implicit ev: T =:= Future[F]): Future[F] =
  FlattenFuture(this.asInstanceOf[Future[Future[F]])

Where FlattenFuture is able to collapse (flatten) the Future[F] type to F so
instead of a Future[Future[F]] we will end up with a Future[F].

We need to use a cast in this case, because the implicit is from T =>
Future[F] but we need to convert this instance to a Future[Future[F]] here.

This is known as a safe cast because the compiler has provided evidence
that it will not fail.
*/

/** <:< Sub-Type Implicit Bounding */
/*One flaw with the above implementation is that it requires the type
parameter to be provided in use*/

//val flattened: Future[String] = futureFutureString.await[String]
/*
val flattened: Future[String] = futureFutureString.await
will not work since the type parameter will be inferred as Nothing before the
implicit evidence is found, and hence the implicit evidence will not be found!*/

/** Using <:< fixes this problem: */
/*
Variance in <:< allows the implicit to be found, then Scala infers the more
appropriate type from there.
*/

/*def flatten[F](implicit ev: T <:< Future[F]): Future[F] =
FlattenFuture(this.asInstanceOf[Future[Future[F])

T must be upper bound by the Same time or more specific one.
*/
