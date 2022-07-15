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

def fact(x: Int): Int = if(x == 0) 1 else fact(x - 1)
fact(4)