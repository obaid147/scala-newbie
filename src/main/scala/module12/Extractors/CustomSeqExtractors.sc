import scala.util.Try

val coordsStr = "-122.432, 34.002"

object CoordSeq {
  def unapplySeq(coordsStr: String): Option[Seq[Double]] = Try {
    coordsStr.split(",").toList.map(_.trim.toDouble)
  }.toOption
}
coordsStr match {
  case CoordSeq(c @ _*) =>
    c foreach println
}
// -121.432
// 34.002
coordsStr match {
  case CoordSeq(x, y, _*) =>
    println(x)
    println(y)
}