import scala.annotation.tailrec

def reverseOfAList(x: List[Int] = Nil):List[Int] = {

   @tailrec
   def tailRecursion(inputList: List[Int], resultList: List[Int] = Nil): List[Int] = inputList match {
     case Nil => resultList
     case h :: t => tailRecursion(t, h :: resultList)
   }

   tailRecursion(x)
 }

 reverseOfAList(List(1,2,3,4,45))