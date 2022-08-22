import scala.util.Random

type Row = List[Int]
type Matrix = List[Row]

def makeMatrix(row: Int, col: Int)(f: () => Int):Matrix = {
  (for(_ <- 0 until row)
    yield (for(_ <- 0 until col)
      yield f()).toList).toList
}

def printMatrix(matrix: Matrix): Unit = {

  matrix.foreach { outer =>
    outer.foreach{ inner =>
      print(inner + " ")
    }
    println()
  }
}


def transpose(matrix: Matrix): Matrix = {
   if(matrix.head.isEmpty) matrix else {
     matrix.map(_.head) :: transpose(matrix.map(_.tail))
   }
}

val randomNumberGenerator: () => Int = () =>  new Random().nextInt(100)
val matrix = makeMatrix(3, 3)(randomNumberGenerator)
printMatrix(matrix)
println("====")
printMatrix(transpose(matrix))
//matrix.print

def multiply(matrix1: Matrix, matrix2: Matrix): Matrix = {
  (for(row <- matrix1)
    yield (for(col <- transpose(matrix2))
     yield (row.zip(col)).map(x => x._1 * x._2).sum))
}

printMatrix(
  multiply(
    makeMatrix(3, 3)(randomNumberGenerator),
    makeMatrix(3,3)(randomNumberGenerator)
)
)

val f: Int => Unit = x => println(x)
List(1,2).foreach(f)


