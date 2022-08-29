val javaArrayList = new java.util.ArrayList[Int]

javaArrayList.add(1)
javaArrayList.add(2)
javaArrayList.add(3)

//javaArrayList.map(_ * 2)
//error: value map is not a member of java.util.ArrayList[Int]
// ----------------CONVERSION from java to scala collection

//import scala.collection.JavaConverters._ deprecated
import scala.jdk.CollectionConverters._
javaArrayList.asScala.map(_ * 2)

/** Note:-
 * import scala.jdk.CollectionConverters._ should be used
 * scala.collection.JavaConverters._ is deprecated */