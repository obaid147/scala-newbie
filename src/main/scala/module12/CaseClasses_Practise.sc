import module10.Person

/*
When you define a case class you get a bunch of things, including pattern
matching
 */

case class Address(street: String,
                   city: String,
                   postCode: Option[String])

case class Person(name: String,
                  phone: Option[String],
                  address: Option[Address])

val address = Address("National Highway link Road", "Srinagar", None)

val obaid = Person("Obaid", None, Option(address))

obaid.name
obaid.phone.getOrElse("No Phone Number")// Some(Address(---))
if(obaid.phone.isDefined) obaid.phone.get else None

obaid.address.getOrElse("")// Address(---)
obaid.address.get.postCode.getOrElse("No Postal Address")// post


def getStreet(bool: Boolean): Option[String] = if(bool) {
  obaid.address.map(_.street)
}else None
// val getStreet = if(true)obaid.address.map(_.street) else None

def getCity(bool: Boolean): Option[String] = if(bool) {
  obaid.address.map(_.city)
}else None


def getPostCode(bool: Boolean) = if(bool) {
  obaid.address.flatMap(x => x.postCode)
}else None

val boo: Boolean = true
val checkStreet: Option[String] = getStreet(boo)
val checkCity: Option[String] = getCity(boo)
val checkPostCode: Option[String] = getPostCode(boo)

val myStreet: String = checkStreet.getOrElse("")
val myCity: String = checkCity.getOrElse("")
val myPostCode: String = checkPostCode.getOrElse("")

/////////////////////////////////
def myProcess(x: String): String = x

checkStreet.fold("")(myProcess)
checkCity.fold("")(myProcess)
checkPostCode.fold("")(myProcess)