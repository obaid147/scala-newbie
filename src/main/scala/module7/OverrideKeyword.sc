/**
 * If a val or def defines a field or method with the same parameter types
    over another of the same name, it must be marked with override.
 * If a val or def defines a field or method that does not
   override a superclass field or method with the same parameter types,
   it must not be marked override
 * If a val or def defines a field or method with the same
   parameter types implementing a previously abstract field or method,
   it may or may not be marked override */

abstract class Superclass{
  def blip: String
  val blop: String = "blop"
  def op(x: Int, y: Int): Int
}

class Subclass extends Superclass{
  def blip: String = "blip" // override optional
  override val blop: String = "bloop" // must be override *and* val
  // MUST override blop because it is already implemented inside superclass
  def op(x: Int, y: Int): Int = x + y // override optional

  def op(x: Double, y: Int): Double = x + y // does not override anything
}

val sub = new Subclass
sub.blip
sub.blop
sub.op(1, 2)
sub.op(1.1, 2)