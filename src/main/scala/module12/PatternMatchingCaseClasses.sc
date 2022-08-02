case class Address(street: String,
                   city: String,
                   postCode: Option[String])

case class Person(name: String,
                  phone: Option[String],
                  address: Option[Address])


val harry = Person("Harry", None, Some(Address(
  "123 Little Whinging way", "Purley", Some("PN22 6RT")
)))
val sally = Person("Sally", Some("321-222-3344"), None)
// Built in useful default toString
harry
sally

// You also get... equals and hashCode that work
sally == harry // false
sally == sally // true
sally == Person("Sally", Some("321-222-3344"), None) // true
sally == Person("Sally", Some("321-234-3344"), None) // false

sally.##
sally.hashCode
Person("Sally", Some("321-222-3344"), None).hashCode
harry.hashCode

// Public parametric fields
harry.name
harry.address.map(_.city).getOrElse("")
harry.phone.getOrElse("")
sally.phone.getOrElse("")

// And, a copy method
val sally2 = sally.copy(address = harry.address,
              phone = Some("321-333-2211"))

val harry2 = harry.copy(phone = sally2.phone)
// case classes are immutable by default, but copy makes
// them easy to work with in a functional way.

// And, you get pattern matching...

def postCodeForHarry(person: Person): String = person match {
  case Person("Harry", _, Some(
              Address(street, city, Some(postcode)))) =>
    println("Harry found with postcode")
    println(s"City $city")
    println(s"Street $street")
    "PostCode = " + postcode
  case _ => ""
}

postCodeForHarry(harry)
postCodeForHarry(harry2)
postCodeForHarry(sally)
postCodeForHarry(sally2)

def postCode(person: Person): String = person match {
  case _ @ Person("Harry", _, Some(
                    Address(_, _, Some(postcode)))) =>
                      postcode
  case _ => ""
}


postCode(sally)