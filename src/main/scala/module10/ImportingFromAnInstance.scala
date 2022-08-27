package module10

import org.scalatest.{FunSuite, Matchers}

case class Person(first: String, last: String, age: Int)

/*class module10.ImportingFromAnInstance extends FunSuite with Matchers{
  val willIAm = module10.Person("WillI", "Am", 44)
  test("module10.Person fields"){
    willIAm.first should be ("WillI")
    willIAm.last should be ("Am")
    willIAm.age should be (44)
  }
}*/

class ImportingFromAnInstance extends FunSuite with Matchers{

  val willIAm = Person("WillI", "Am", 44)
  test("module10.Person fields"){
    import willIAm._ // imported from an instance of a module10.Person class
    first should be ("WillI") // now, we don't need willIAm.first...etc
    last should be ("Am")
    age should be (44)
  }
}