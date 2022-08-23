import java.util.UUID
import scala.util.Try

trait DBAccess{
  def save[T](item: T): String
  def load[T](id: String): Option[T]
}

class FakeDBAccess extends DBAccess{
  private[this] var itemMap = Map.empty[String, Any]

  override def save[T](item: T): String = {
    val uuid = UUID.randomUUID().toString
    itemMap += (uuid -> item)
    uuid
  }

  override def load[T](id: String): Option[T] = {
    Try(itemMap(id).asInstanceOf[T]).toOption
  }
}

case class Person(name: String, age: Int)

val fake = new FakeDBAccess
val uuid = fake.save(Person("obaid", 28))
fake.load(uuid)