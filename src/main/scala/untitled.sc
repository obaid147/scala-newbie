object FactSeqNested{

  def factSeq(n: Int): List[Long] = {
    //    factSeqInner(n, List(1L), 2)
    //    We cannot keep it here, Because In scala last statement is the return statement

    import scala.annotation.tailrec
    @tailrec
    def factSeqInner(acc: List[Long], ct: Int): List[Long] = {
      if(ct > n) acc
      else factSeqInner(ct * acc.head::acc, ct + 1)
    }
    factSeqInner(List(1L), 2)
  }
}
FactSeqNested.factSeq(4)

import scala.language.implicitConversions
implicit def doubleToInt(d: Double): Int = d.toInt
val x: Int = 24.7

def fn2: (Int, Int) => Int = (a, b) => a + b
fn2(2, 3)

implicit val d2I: Double => Int = i => i.toInt
d2I(x)
doubleToInt(2.2)


val lol: List[List[Int]] = List(List(1, 2), List(3, 4))
val resList: List[Int] = lol.flatten
val lov: List[Vector[Int]] = List(Vector(1,2), Vector(3,4))
val resVector: List[Int] = lov.flatten[Int]

val lols: List[List[String]] =  List(List("ab", "cd"), List("ef", "gh"))
val resFS: List[String] = lols.flatten
val resCMS: List[String] = resFS.map(_.capitalize).sorted

val myFriends = List("Adam", "David", "Frank")
val adamsFriends = List("Nick K", "Bill M")
val davidsFriends = List("Becca G", "Kenny D", "Bill M")
val friendsOfFriends = List(adamsFriends, davidsFriends)
// creating a unique list of the friends of myFriends
val UniqueFriends = friendsOfFriends.flatten.distinct

val cos: List[Char] = lols.flatten.flatten[Char]

val loOS: List[Option[String]] = List(Some("obaid"), None, Some("Fayaz"))
val loS: List[String] = loOS.flatten

List(Set(1)).flatten

loOS
loOS.flatten.map(_.toUpperCase)
loOS.flatMap(_.map(_.toUpperCase))

myFriends.flatten.map(_.toUpper)
myFriends.flatMap(_.toUpperCase)

val fmL: List[Int] = List(2,3,4)
fmL.map(x => List(x-1, x, x+1)).flatten
val r: List[Int] = fmL.flatMap(x => List(x-1, x, x+1))
