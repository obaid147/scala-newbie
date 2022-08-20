import scala.annotation.tailrec

/*val elements = List(List(1, 2, 3), List(4, 5, 6),
                List(7, 8, 9))

for(i <- elements.indices){
  for(j <- elements.indices){
    print(elements(j)(i) + " ")
  }
  println()
}


@tailrec
def rec(xs: List[List[Int]], acc1: Int, acc2: Int): Unit  = {
  if(acc2 < xs.length) {
    print(xs(acc2)(acc1) + " ")
    rec(xs, acc1, acc2 + 1)
  } else if(acc2 == xs.length && acc1 == xs.length-1){
    ()
  } else {
    println()
    rec(xs, acc1 + 1, acc2 = 0)
  }
}
rec(elements, 0, 0)*/


val elements = List(List(1, 2, 3),
                    List(4, 5, 6),
                    List(7, 8, 9))

@tailrec
def transpose(xs: List[List[Int]]): Int = {
  if(xs.head.isEmpty) -1
  else {
    println(xs.map(x => x.head))
    transpose(xs.map(x => x.tail))
  }
}

transpose(elements)

elements.map(x => x.head).head
elements.map(x => x.tail)


val elements1 = List(List(1, 2, 3))//,
//                      List(4, 5, 6),
//                      List(7, 8, 9))

val elements2 = List(List(10, 11, 12))//,
//                      List(13, 14, 15),
//                      List(16, 17, 18))

println("First Matrix\n" + elements1)
println("First Matrix\n" + elements2)

def multi(xs1: List[List[Int]], j: Int,
          xs2: List[List[Int]], m: Int): Any = {
  if(m < xs1.length){
    print(xs1.head(j) * xs2.head(m) + " ")
    multi(xs1, j, xs2, m+1)
  }
  else {
    if(j < xs1.length) {
      println()
      multi(xs1, j + 1, xs2, m = 0)
    }
    else xs1.head(j) * xs2.head(m)
  }
}
multi(elements1, 0, elements2, 0)

