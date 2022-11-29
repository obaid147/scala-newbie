import scala.util.control.NonFatal

case class DB(url: String, user: String, pass: String)
case class User(name: String, pass: String)

case class Session(id: String) {
  def query(q: String) = User("oby", "myPass")
}

def withTransaction[A](db: DB)(fn: Session => A): A = {
  println(s"Session starting on DB ${db.url}")
  try {
    val a: A = fn(Session("test"))
    println(s"Committing transactions on DB ${db.url}")
    a
  }catch {
    case NonFatal(ex) =>
      println(s"Rolling back transactions on DB ${db.url}")
      throw ex
  }
}

object PostgresDBDetails {
  val dbUrl = "jdbc:postgres://localhost:5432"
  val dbUser = "user"
  val dbPass = "pass"
}

object PostgresDBConnection {
  import PostgresDBDetails._ // hard wired above
  def db = DB(dbUrl, dbUser, dbPass)
}

class UserManagement {
  val db = PostgresDBConnection.db // more hard wiring
  def findUser(id: Int): User = {
    withTransaction(db) { s => s.query(s"select * from users where id = $id")
    }
  }
}

(new UserManagement).findUser(123)