import scala.annotation.tailrec
// print 1 to 5

@tailrec
def rec(x: Int): Int = {
  if (x > 5) 0
  else {
    println(x)
    rec(x+1)
  }
}

rec(1)

// print sum of first n digits

def sum(x: Int): Int ={
  if (x == 1) 1
  else
    x + sum(x-1) // this is a pending computation
}

//println("Enter a number: ")
//val aNumber = scala.io.StdIn.readInt()
//sum(50000000)

//tail recursion

def sum(sumOfNumber: Int): Int = {

  @tailrec
  def sumTailRecursion(x: Int, acc: Int): Int = {
    if (x == 0) acc else {
      sumTailRecursion(x - 1, x + acc)
    }
  }
  sumTailRecursion(sumOfNumber, 0)
}
//x acc, 5 0, 4 5, 3 9, 2 12, 1 14, 0 15

//sum(50000000)
sum(5)

/**
 *
 */

//todo: find nth fibo number, first with normal recursion then tail recursion

def nFibo(n: Long): Long = {
  if(n <= 1) n else {
    nFibo(n - 1) + nFibo(n - 2)
  }
}
nFibo(10)

def mainFibo(n: Int, a: Int = 0, b: Int = 1): Int = {
  @tailrec
  def tailFibo(n: Int, a: Int, b: Int): Int = {
    if(n == 0)
      a
    else if
      (n == 1) b
    else
      tailFibo(n - 1, b, a + b)
  }
  tailFibo(n, a, b)
}

mainFibo(6)

// todo: reverse of a string

def revs(s: String): String = {
   if (s.isEmpty) "Empty String"
  else if (s.length == 1)  s
  else revs(s.tail) + s.head
  //else revs(s.substring(1)) + s.charAt(0)
}
revs("Obaid")

def revString(str:String):String={
  @tailrec
  def rev(str:String,r:String):String={
    if (str == "") r
    else rev(str.tail, str.head + r)
  }
  rev(str,"")
}

revString("ABCD")

//-------------------------------

object FactSeq{

  def factSeq(n: Int): List[Long] = {
    factSeqInner(n, List(1L), 2)
  }

  @tailrec
  private def factSeqInner(n: Int, acc: List[Long], ct: Int): List[Long] = {
    if (ct > n) acc
    else factSeqInner(n, ct * acc.head :: acc, ct + 1)
  }
}
FactSeq.factSeq(4)
//FactSeq.factSeq(4).reverse









