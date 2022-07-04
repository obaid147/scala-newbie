package module4

//class Question{
//
//
//}

object Question extends App{

    val xs = List(1,2,3,4)
    val ys = List(2,3,4,5)
    val res = for {
      x <- xs
      if x % 2 == 0
      y <- ys
      if y > 3
    } yield x * y
  println(res)
}
