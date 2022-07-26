class Person(name: String, age: Int) {
  def isAdult: Boolean = age > 21
}
// A class definition can have new instances created for it.
val p1 = new Person("ABC", 22)
p1.isAdult
val p2 = new Person("DEF", 17)
p2.isAdult

// Because it is not marked abstract,
// you are able to create a new instance

//t is not marked abstract, all
// fields and methods must have definitions

//
// When you call new in Scala, you always get a new instance

new String("hello").equals(new String("hello"))
new String("hello").eq(new String("hello"))
"hello".eq("hello")
//eq is instance equality in Scala, while == always calls .equals
