//In Scala, == is always aliased to call .equals
//It's tempting to try and override it to do something else:

class BadClass {
//  override def ==(other: Any): Boolean = {
//    println(s"Comparing $this to $other")
//    false
//  }
}
//But if we try:
// Error: overriding method == in class Object of type (x$1: Any)Boolean;
// method == cannot override final member
// override def ==(other: Any): Boolean = {

//Redefining the meaning of == would be a very bad idea, so it is marked
//final in AnyRef

//We can do the same with our own classes
class Authority {
  final def theWord: String =
    "This is the final word on the matter!"
}
class Argumentative extends Authority {
//  override def theWord: String =
//    "No, it's not!"
}
// Error: overriding method theWord in class Authority of type => String;
// method theWord cannot override final member
// override def theWord: String =
// ^