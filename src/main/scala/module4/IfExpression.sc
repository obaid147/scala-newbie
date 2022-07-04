import scala.collection.immutable

val res: AnyVal = if(10 > 12) 12 else false
res
// AnyVal

val x = if (10 > 12) 12 else 10
x // Int

val l = (1 to 10).toList
val n: Any = if(180 > 12) 180 else l // Any
