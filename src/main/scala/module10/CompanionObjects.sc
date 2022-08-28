/**Companion objects can share private state, but not private[this]*/

//private constructor, other classes can't create new instance
// of shipping container.
class ShippingContainer[T] private(val items: Seq[T]){
  private[this] val maxCount = 3
  private def isFull: Boolean = items.length >= maxCount

  override def toString: String = s"${ShippingContainer.containerColor} Container"
}

// private constructor force us to call factory methods.
object ShippingContainer{
  def apply[T](items: T*) = new ShippingContainer[T](items)

  private def containerColor: String = "Green"
//  def maxItem(container: ShippingContainer[_]): Int = container.maxCount //compile error maxCount is private[this]

  def containerFUll(container: ShippingContainer[_]): Boolean = container.isFull
}

val sc = ShippingContainer("a", "b", "c")// toString gives color
//sc.containerColor //cannot access here, private
sc.items // Seq(a, b, c)
//sc.maxCount //cannot access here, private[this]
//sc.isFull //cannot access here, private

ShippingContainer.containerFUll(sc)// depends on maxCount

/** A class or trait definition and an object definition with the
 * same name and reside in the same file.
 * These are considered as companions.
 * They share private state and private behaviour.
 * They don't share private[this] as it is instance specific*/