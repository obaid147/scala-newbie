import module10.demo.food.domain.api.Dessert
/**
 * Packages are a way of organizing classes and objects.
 * Always declare a package at the start of a source file (and everything in that
   *source file is then in that package):
 */

case class IceCream(x: String) extends Dessert{
   def apply(): String =
      s"$x"

   override def isCheap(): Boolean = false
}
object PackagesAndPackageStructure extends App{
   val iceCream = IceCream("Mango")
   println(iceCream.apply())
   println(iceCream.isCheap())
}

// Alternative
