/**Only a trait can go after the with keyword, not a class
 */
abstract class Car{
  def color: String
  def describe: String = s"$color"

  override def toString: String = s"$describe car"
}

trait Classic extends Car{
  def vintage: Int
  override def describe: String =
    s"vintage $vintage ${super.describe}"
}

trait Convertible extends Car{
  override def describe: String =
    s"convertible ${super.describe}"
}

trait PoweredConvertible extends Convertible {
  override def describe: String =
    s"powered ${super.describe}"
}

trait HardTopConvertible extends Convertible{
  override def describe: String =
    s"hard-top ${super.describe}"
}
//STACK TRACE 1
class ClassicConvertible1(val color: String, val vintage: Int)
  extends Car with  PoweredConvertible with Classic with HardTopConvertible
//  extends Car with Convertible with PoweredConvertible with Classic with HardTopConvertible
new ClassicConvertible1("Blue", 1991)
// we get convertible from convertible trait without extending.
/**
 * 1. HardTopConvertible -> 2. Classic
 * -> 3. PoweredConvertible
 * -> 4. It did not went to Car trait because
 * PoweredConvertible is 2 levels below Car trait,
 * So it first goes to it's super(Convertible) trait then,
 * Convertible goes to the Car which is Convertible Super.*/
//hard-top vintage 1994 powered convertible Blue car.

// STACK TRACE 2
class ClassicConvertible2(val color: String, val vintage: Int) extends Car
  with Classic with PoweredConvertible with HardTopConvertible

new ClassicConvertible2("Red", 1992)
// hard-top powered convertible vintage 1965 Red car.
/**
 * 1. HardTopConvertible -> 2. PoweredConvertible
 * -> 3. Convertible
 * -> 4. It did not went to Classic trait because
 * PoweredConvertible is 1 levels below Convertible trait,
 * and is also not subClass to Classic trait.
 * So it first goes to it's super(Convertible) trait then,
 * Convertible goes to the Classic and Classic goes to Car.*/

// STACK TRACE 3
class ClassicConvertible3(val color: String, val vintage: Int) extends Car
  with PoweredConvertible with HardTopConvertible with Classic

new ClassicConvertible3("Green", 1993)
// vintage 1993 hard-top powered convertible Green car
/**Only  subclasses of Convertible can call it*/
