// embedded class
case class Person1(name: String) {
  case class LifePartner1(name: String) {
    def describe1: String = s"$name is partner of $name"
  }
}

Person1("ABC").LifePartner1("DEF").describe1
// Both case classes refer to the LifePartner name


/**Self Aliases*/
case class Person2(name: String) { outer => // alias for outer class
  case class LifePartner2(name: String) { inner => // alisa for inner class
    def describe2: String =
      //s"${this.name} is partner of ${outer.name}" // with outer, & without inner.
      s"${inner.name} is partner of ${outer.name}"// with outer & inner.
  }
}
Person2("XYZ").LifePartner2("PQR").describe2

///////////////////////
import com.typesafe.scalalogging.LazyLogging

trait Loves { mee: LazyLogging =>
  def loves(l1: AnyRef, l2: AnyRef): Unit =
    logger.error(s"$l1 loves $l2")
}
/** trait Loves
 *  This is not the same as extending LazyLogging but when we create a concrete instance of Loves trait,
 *  We will also need to supply LazyLogging,
 *  this: LazyLogging => we can rename it(this to me...), It also specifies dependency on a type
 *  without specifying an actual inheritance hierarchy
 *  It simply means LazyLogging must be there, Whenever i create logs & It also means that i can call
 *  methods on LazyLogging like logger.error()*/


case class Lovers(name1: String, name2: String)
  extends Loves with LazyLogging {
  def desc(): Unit = loves(name1, name2)
}
/** Lovers is a concrete instance and we must supply LazyLogging or it wont work(Illegal Inheritance)*/
Lovers("aa", "bb").desc()
