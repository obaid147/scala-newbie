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

trait DBConnection { val db: DB }
// change object to class

class PostgresDBConnection(dbURL: String, dbUser: String, dbPass: String) extends DBConnection {
  val db = DB(dbURL, dbUser, dbPass)
}

class UserManagement(dbConn: DBConnection) {
  val db = dbConn.db
  def findUser(id: Int): User = {
    withTransaction(db) { s => s.query(s"select * from users where id = $id")
    }
  }
}

val dbConn = new PostgresDBConnection(
  "jdbc:postgres://localhost:5432", "user", "pass")

new UserManagement(dbConn).findUser(121)


/*Constructor Parameters in a Large System
* The problem with constructor parameter passing is that it quickly becomes unmanageable.
* All parameters must be chained down from the top level to the components
*   that need them, pretty soon you are going to end up with methods that look like below code:-

* */

/*
def wsLookupUserWeather(
                         s3Conn: S3Connection,
                         dbConn: DBConnection,
                         wsClient: WebServiceClient,
                         weatherService: WeatherService,
                         retryPreferences: Retrying,
                         emailer: EmailService,
                         security: SecurityService
                       ) */
/*
And so on. When a method needs a new dependency passed in, it must then
be added all the way up to the top. */
