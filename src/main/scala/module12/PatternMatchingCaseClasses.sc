case class Address(street: String,
                   city: String,
                   postCode: Option[String])

case class Person(name: String,
                  phone: Option[String],
                  address: Option[Address])

val address = Address("National Highway link Road", "Srinagar", None)

val obaid = Person("Obaid", None, Option(address))