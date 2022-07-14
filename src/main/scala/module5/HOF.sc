import scala.annotation.tailrec

def sum(f: Int => Int, a: Int, b: Int): Int ={
    if(a > b) 0
    else
        f(a) + sum(f, a+1, b)
}

def id(x: Int): Int = x
def cube(x: Int): Int = x * x * x
@tailrec
def fact(x: Int): Int = {
  if(x == 0) 1 else fact(x - 1)
}

def sumInts(a: Int, b: Int): Int = sum(id, a, b)
def sumCubes(a: Int, b: Int): Int = sum(cube, a, b)
def sumFactorial(a: Int, b: Int): Int = sum(fact, a, b)

sumInts(1, 2)
sumCubes(1, 2)
sumFactorial(1, 2)