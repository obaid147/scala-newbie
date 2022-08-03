// Generators in a for block are also pattern matches.

val numbersMap = Map(1 -> "one", 2 -> "two", 3 -> "three")

for((k, v) <- numbersMap){
  println(s"Key is $k and Value is $v")
}

// A non-match will just short-circuit the for so there's
// no exception if no match

case class Address(street: String, city: String,
                   postCode: Option[String])

case class Person(name: String, phone: Option[String],
                  address: Option[Address])

//////////////////////////////////////////////////////
lazy val harry = Person("Harry", None, Some(Address(
  "123 Little Whinging way", "Purley", Some("PN22 6RT"))))

lazy val sally = Person("Sally", Some("321-222-3344"), None)
////////////////////////////////////////////////////
lazy val sally2 = sally.copy(address = harry.address,
  phone = Some("321-333-2211"))

lazy val harry2 = harry.copy(phone = sally2.phone)

val people = List(harry, harry2, sally, sally2)

for {
  Person(name, phone, _) <- people
  if phone.isDefined
} yield name -> phone.get