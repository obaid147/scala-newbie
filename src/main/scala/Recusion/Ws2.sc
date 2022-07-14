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

def factorial(n: Int): Int = {
  def loop_(acc: Int, n: Int): Int = {
    if(n == 0) acc
    else
      loop_(acc * n, n - 1)
  }
  loop_(1, n)
}

factorial(4)