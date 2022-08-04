import scala.util.Try

val coordsStr = "-122.432, 34.002"
object Coords {
  def unapply(coordsStr: String): Option[(Double, Double)] = Try {
    val fields = coordsStr.split(",").map(_.trim.toDouble)
    (fields(0), fields(1))
  }.toOption
}
coordsStr match {
  case Coords(x, y) =>
    println(s"x = $x")
    println(s"y = $y")
}
