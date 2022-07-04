import scala.annotation.tailrec

def mainTable(table: Int): String = {

  @tailrec
  def multiTable(n: Int = 1,  acc: String = ""):String = {
    if (n > 10) acc else {
      val s = acc + s"\n$table * $n = ${table * n}\n"
      multiTable(n + 1, s)
    }
  }
  multiTable()
}

mainTable(5)