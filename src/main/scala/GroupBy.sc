import scala.collection.immutable

val m = Map(
   "aamir" -> "sonwar",
  "obaid" -> "batmaloo",
  "zahid" -> "pampore",
  "fayaz" -> "sonwar",
  "aqsa" -> "pampore"
)

val r: Map[String, Map[String, String]] = m.groupBy(_._2)

val r2 = m.groupBy(_._2).map {
  case (key, value) =>
    Map(key ->  value.keys)

}