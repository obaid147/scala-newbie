def gravity = 9.81

def force(mass: Double = 1,
  acceleration: Double = gravity): Double =
  mass * acceleration

force()
force(12)
force(acceleration = 2 * gravity)
force(acceleration = gravity / 13, mass = 100)

def factSeq(n: Int, acc: List[Long] = List(1L),
            ct: Int = 2): List[Long] =
  if (ct > n) acc
  else
    factSeq(n, acc = ct * acc.head :: acc, ct = ct + 1)


factSeq(4)
