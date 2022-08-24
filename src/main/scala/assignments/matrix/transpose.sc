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
      print(s"$inner        ")
    }
    println()
  }
}


def transpose(matrix: Matrix): Matrix = {
   if(matrix.head.isEmpty) matrix else {
     matrix.map(_.head) :: transpose(matrix.map(_.tail))
   }
}
val m = makeMatrix(3,3)(() => 1 + Random.nextInt(50))
printMatrix(m)
val t = transpose(m)
printMatrix(t)

val randomNumberGenerator: () => Int = () =>  1 + new Random().nextInt(50)

val matrix = makeMatrix(3, 3)(randomNumberGenerator)
val transposeMatrix = transpose(matrix)
printMatrix(matrix)
println("====")
printMatrix(transpose(matrix))
//matrix.print

def multiply(matrix1: Matrix, matrix2: Matrix): Matrix = {
  for(row <- matrix1)
    yield for(col <- matrix2)
     yield row.zip(col).map(x => x._1 * x._2).sum
}


val matrix2 = makeMatrix(3, 3)(randomNumberGenerator)
printMatrix(matrix2)

val matrix1: Matrix = makeMatrix(3, 3)(randomNumberGenerator)
printMatrix(matrix1)
val transposeMatrix2: Matrix = transpose(matrix2)
printMatrix(transposeMatrix2)

printMatrix(
  multiply(
    matrix1,
    transposeMatrix2
)
)

val x: List[List[Int]] = for(row <- matrix1) yield{
  for(col <- transposeMatrix2) yield {
    row.zip(col).map(x => x._1 * x._2).sum
  }
}