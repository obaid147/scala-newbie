package assignments
import scala.util.Random
/**
 1 2 3 4 5 6 7 8 9 10
 2 3 4 5 6 7 8 9 10
 */

object GenerateARandomList {
  def returnRandomList(n: Int): List[Int] = List.fill(n)(Random.nextInt())

}

object GenerateARandomTupleList {
  def returnRandomListTuple(n: Int): List[(Int,Int)] = {
    (0 to n).foldLeft(Map.empty[Int,Int]) { (acc, _) =>
      acc + (Random.nextInt() -> Random.nextInt()) }.toList

  }
}
object ListIsInAscendingOrder extends App {

  val l =  (1 to 10).toList
  val randomList =  GenerateARandomList.returnRandomList(10)

   val l2 = l.splitAt(5)
  val l3 = l2._1 ++ List(33) ++ l2._2
  println(l3)


  val bool = l3.zip(l3.tail).forall( tup => tup._1 < tup._2)
  println(bool)
  println(GenerateARandomTupleList.returnRandomListTuple(10))


}