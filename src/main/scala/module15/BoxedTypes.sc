import scala.jdk.CollectionConverters._
def someJavaFunc(xs: java.util.List[Integer]): Unit

val sL = List(1, 2, 3)

//val r1 = someJavaFunc(sL.asJava)

val jL2 = sL.map( new java.lang.Integer(_))

val r2 = someJavaFunc(jL2.asJava)

/**
 * sL.asJava will convert the wrapper list but
 * 1, 2, 3 are Ints not Integers
 * We will get type mismatch
 * line 8 new java.lang.Integer(_)
 * Implicitly boxes it into the java form first
 */
