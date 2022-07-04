import scala.annotation.tailrec
// print a string n times

def mainString(str: String, n: Int): String = {
  @tailrec
  def InnerString(n: Int, a: String=""): String = {

    if (n < 1) {
      a
    }
    else {
      InnerString(n-1, a + str)
    }
  }
  InnerString(n)
}

mainString("ABc", 3)