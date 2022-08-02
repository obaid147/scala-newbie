/**
 * Both have different syntax for defining. Case class need () where as class does not.
 * While creating objects of case class, new keyword is not used which is used to create instances of case class.
 * Regular classes do not support pattern matching whereas case class support pattern matching.
 * Regular classes can be inherited by another class whereas case classes cannot be inherited or extended.
 * Regular classes do not have any predefined method whereas case class has predefined hashcode and equals method.
 * The comparison of objects of class is done using reference comparison whereas
      * the objects of case class compare the structure of objects.
 */

class A(name: String) // defining a class / concrete
case class B()// defining a case class

val obj1 = new A("Obaid") // new instance of class
val obj2 = new A("Obaid") // new instance of class
val obj11 = B // new instance of case class
val obj22 = B // new instance of case class

//case class N()
//case class A() extends B(){
//  println(super.n)
//}
//A()
//case-to-case inheritance is prohibited.

obj1 // class does not have a nice toString method.
obj11 // case class have a nice toString method.


obj1 == obj2 // comparing diff instances of class(false)
obj11 == obj22 // comparing diff instances of case class(true)



