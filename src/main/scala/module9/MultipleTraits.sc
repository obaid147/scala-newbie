abstract class Car{
  def color: String
  def describe: String = s"$color"

  override def toString: String = s"$describe car"
}

trait Classic extends Car{
  def vintage: Int

  override def describe: String = s"Vintage $vintage ${super.describe}"
}

trait Convertible extends Car{
  def powerTop: Boolean

  override def describe: String = {
    val top = if(powerTop) "Powered Convertible" else "Convertible"
    s"$top ${super.describe}"
  }
}

class ClassicConvertible(val color: String, val vintage: Int, val powerTop: Boolean)
  extends Car with Classic with Convertible

val mustang = new ClassicConvertible("red", 1965, true)
//The super is not decided until the trait is mixed in to a concrete class
// linearization
/**
 * Powered Convertible OR Convertible from Convertible trait
 * Vintage {Year} from Classic trait
 * red car from abstract class Car
 */

/**
A Scala class can extend multiple traits at once,
but JVM classes can extend only one parent class.
The Scala compiler solves this by creating "copies of each
trait to form a tall, single-column hierarchy of the class
and traits", a process known as linearization.
 */

trait Base {
  override def toString = "Base" }
class A extends Base {
  override def toString = "A->" + super.toString }
trait B extends Base {
  override def toString = "B->" + super.toString }
trait C extends Base {
  override def toString = "C->" + super.toString }
class D extends A with B with C {
  override def toString = "D->" + super.toString }

new D() //  D->C->B->A->Base
//This perfectly reflects the structure of
// the linearized inheritance graph.

// MultiLevel Inheritance
trait Base1 {
  override def toString = "Base" }
class A1 extends Base1 {
  override def toString = "A->" + super.toString }
trait B1 extends A1 {
  override def toString = "B->" + super.toString }
trait C1 extends B1 {
  override def toString = "C->" + super.toString }
class D1 extends A1 with B1 with C1 {
  override def toString = "D->" + super.toString }

new D1()