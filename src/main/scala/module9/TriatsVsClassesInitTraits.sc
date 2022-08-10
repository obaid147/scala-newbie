/** --------- Triats vs Classes

 * 1. Concrete classes and abstract classes can have constructor
      parameters. Traits cannot.
 * 2. This also means traits cannot have implicit parameters or context bounds.
      A context bound is short-hand for an implicit parameter.
      This may change in the future.
 */

case class CoordinatesClass(x: Double, y: Double){
  val distanceToOrigin: Double = math.sqrt((x * x) + (y * y))
}

val d1 = CoordinatesClass(3.0, 4.0)
d1.distanceToOrigin

//trait CoordinatesTraitT(x: Double, y: Double)
// We should use abstract val's instead

trait CoordinatesTrait{
  def x: Double
  def y: Double

  override def toString: String = s"($x, $y)"
  def distanceToOrigin: Double = math.sqrt((x * x) + (y * y))
}

//----------------------Trait Initialization

case class Coords() extends CoordinatesTrait {
  val x = 3.0
  val y = 2.0
}
val c = Coords() // Trait Initialization
c.distanceToOrigin

case class Coords2(x: Double, y: Double) extends CoordinatesTrait
val c2 = Coords2(3.0, 2.0)// Trait Initialization
c2.distanceToOrigin

val c3 = new CoordinatesTrait {
  val x: Double = 3.0
  val y: Double = 4.0
}
c3.distanceToOrigin // 5.0

val c4: CoordinatesTrait = new  {
  val x: Double = 3.0
  val y: Double = 4.0
} with CoordinatesTrait
c4.distanceToOrigin // 5.0

// ---------- using lazy val
trait LazyTrait{
  def x: Double

  override def toString: String = s"$x"
  lazy val addition: Double = x + 1
}

val c5 = new LazyTrait {
  override def x = 10.1
}
c5.addition
