/** Left to its own devices, Scala will often infer more than you need:*/

//trait Fruit extends Product with Serializable
trait Fruit
case class Apple(color: String) extends Fruit
case class Orange(color: String) extends Fruit

if(true) Apple("Red") else Orange("")

List(Apple("Red"), Orange("Orange"))

/**
 * Since case classes extend both Product and Serializable.
 * You can explicitly type the result as below:
 */

val res = if(true) Apple("Red") else Orange("Orange")