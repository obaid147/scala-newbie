import module10.Person

case class Address(street: String,
                   city: String,
                   postCode: Option[String])

case class Person(name: String,
                  phone: Option[String],
                  address: Option[Address])

lazy val harry = module10.Person("Harry", None, Some(Address(
  "123 Little Whinging way", "Purley", Some("PN22 6RT")
)))
lazy val sally = module10.Person("Sally", Some("321-222-3344"), None)

val Person(name, phone, Some(Address(_, _, postCode))) = harry

// val is a pattern-match
//Which means it can fail...

val Person(name2, phone2, Some(Address(_, _, postCode2))) = sally
//This fails because sally has no Address recorded
// Be aware of this if you use a val with a pattern match -
// you may get a match error