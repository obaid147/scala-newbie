import scala.annotation.tailrec

def sayName(name: String): String = {
  s"Hey, $name"
}
//sayName("Obaid")
sayName(name="Obaid") // Named Parameter
// This is considered best practice for Boolean parameters in particular:

def thingy(isCold: Boolean, isBroken: Boolean): Boolean = {
  if(isCold) isCold
  else isBroken
}
thingy(isBroken = false, isCold = true)// And if you use the names, you can choose any order:

// -------------------------
//Couple With Default Parameters
def gravity = 9.81

def force(mass: Double=1, acceleration: Double = gravity): Double ={
  mass * acceleration
}
force()
force(12)
force(acceleration = 2 * gravity)
force(acceleration = gravity / 13.0, mass = 100)

// or for recursion:
@tailrec
def factSeq(n: Int, acc: List[Long] = List(1L), ct: Int = 2): List[Long] = {
  if (ct > n) acc else factSeq(n, acc = ct * acc.head :: acc, ct = ct + 1)
}
factSeq(4)