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


val elements1 = List(List(1, 2, 3),List(4, 5, 6))
val elements2 = List(List(10, 11),List(12, 13), List(14, 15))
var xs3 = Array.ofDim[Int](2, 2)

def multi(xs1: List[List[Int]],
          xs2: List[List[Int]]) = {

  var i = 0
  while (i < xs1.length) {
    var j = 0
    while (j < xs1.length) {
      var sum = 0
      var k = 0
      while (k <= xs1.length) {
        sum = sum + (xs1(i)(k) * xs2(k)(j));
        k = k + 1
      }
      println(sum + " ------ sum")
      xs3(i)(j) = sum
      j = j + 1
    }
    i = i + 1
  }

  printf("Multiplication of Matrix1 and Matrix2:\n")
  i = 0;
  while (i < xs1.length) {
    var j = 0;
    while (j < xs1.length) {
      print(xs3(i)(j) + " ");
      j = j + 1;
    }
    i = i + 1;
    println();
  }

}
multi(elements1, elements2)

