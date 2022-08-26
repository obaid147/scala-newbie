import java.util.UUID
import scala.util.Try

trait DBAccess{
  def save[T](item: T): String
  def load[T](id: String): Option[T]
}

class FakeDBAccess(private[this] var itemMap:
                   Map[String, Any]) extends DBAccess{

  def save[T](item: T): String = {
    val uuid = UUID.randomUUID().toString
    itemMap += (uuid -> item)
    uuid
  }

  def load[T](id: String): Option[T] = {
    Try(itemMap(id).asInstanceOf[T]).toOption
  }
}

case class Person(name: String, age: Int)

val fake = new FakeDBAccess(Map.empty[String, Any])
val uuid = fake.save(Person("zak", 45))
fake.load(uuid)