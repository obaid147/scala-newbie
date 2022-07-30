// String subClass of AnyRef which is subclass if Any
val s: String = "hello"
val sa: Any = s // OK
val sar: AnyRef = s // OK
//val sav: AnyVal = s // Compile Error

// Int comes under AnyVal which is subclass if Any
val i: Int = 10
val ia: Any = i // OK
val iav: AnyVal = i // OK
//val iar: AnyRef = i // Does not compile

ia.isInstanceOf[Int] // true
ia.asInstanceOf[Int] // Int: 10
try{
  ia.asInstanceOf[String]// Class cast exception
}catch{
  case _: ClassCastException =>
    "\nClass Case Exception, Casting an Object of one data type to another"
}
  sa.isInstanceOf[String]// true
sa.asInstanceOf[String]// String: hello
try{
  sa.asInstanceOf[Int] // Class cast exception
}catch{
  case e: ClassCastException =>
    "\nClass Case Exception, Casting an Object of one data type to another"
}
