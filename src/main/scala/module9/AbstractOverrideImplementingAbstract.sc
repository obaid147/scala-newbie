/**
 * Override  a method in a trait that may be abstract in the superclass.
    Using abstract override
 * Some other trait must supply a non-abstract implementation in a concrete
    definition
 */

abstract class Vehicle{
    def describe: String
    override def toString: String = s"$describe"
}

trait Classic extends Vehicle{
    def vintage: Int
    abstract override def describe: String =
        s"$vintage ${super.describe}"
}

trait Convertible extends Vehicle{
    def poweredTop: Boolean

    abstract override def describe: String = {
        val top = poweredTop match {
            case _ if poweredTop => "Powered-Convertible"
            case _ => "Just-Convertible"
        }
        s"$top ${super.describe}"
    }
}

// -------- Implementing Abstract
trait Car extends Vehicle{
    def color: String
    override def describe: String = s"$color car"
}
//
class ClassicConvertible(
val color: String, val vintage: Int, val poweredTop: Boolean
) extends Car with Classic with Convertible

val n = new ClassicConvertible("Black",
                    1234, true)


/**
 * Creating a class and extending abstract class will result:-
 * If we tried to use abstract override def describe.....
 * We get an error,
 * abstract override modifier only allowed for members of trait.
 */
