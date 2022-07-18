
def prodF1(f: Int => Int): (Int, Int) => Int = {
  def inner(a: Int, b: Int): Int = {
    if(a < b) inner(b, a)
    else if (b != 0) f(a) + inner(a, b-1)
    else 0
  }
  inner
}

prodF1(x => x)(2, 2)

def prodF2(f: Int => Int)(a: Int, b: Int): Int = {
  if(a > b) prodF2(f)(b, a)
  else if(b != 0) f(a) + prodF2(f)(a, b-1)
  else 0
}

prodF2(x => x)(3, 3)

def prodF3(f: Int => Int)(a: Int, b: Int): Int = {
  if(a > b) 1
  else f(a) * prodF3(f)(a + 1, b)
}
prodF3(x => x * x)(3, 4) // square of all in b/w 3 & 4

def fact(n: Int) = prodF3(x => x)(1, n)
fact(5)

//  --------------------------------------
def mapReduce(f: Int => Int,
  combine: (Int, Int) => Int,
  zero: Int)(a: Int, b: Int): Int =
  if (a > b) zero
  else {
    combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
  }
def prodF4(f: Int => Int)(a: Int, b: Int): Int =
  mapReduce(f, (x, y)=> x * y, 1)(a, b)
prodF4(x => x * x)(3, 4)
// ----val n = prodCubes


/*def products(f: Int => Int): (Int, Int) => Int = {
  def inner(a: Int, b: Int): Int = {
    if(a < b) inner(b, a)
    else if(b != 0) f(a) + inner(a, b-1)
    else inner(b, a)
  }
  inner
}*/
//def prodInts = products(x => x)
//def prodCubes = products(x => x * x * x)
def products(f: Int => Int)(a: Int, b: Int): Int = {
    if(a > b) 1
    else f(a) * products(f)(a + 1, b)
}


products(x => x)(3, 3)

def fact(n: Int) = products(x => x)(1, n)
fact(5)


