class ws1(name: String, age: Int){
  val s1 = "One"
  val s2 = "Two"

  override def toString: String = s"$s1, $s2, $name, $age"

}

object ws1{

  def apply(name: String, age: Int): ws1 = {
   new ws1(name, age)
  }

  def apply(age: Int): ws1 = {
    new ws1("FAW", age)
  }
}

ws1.apply("Fayaz", 62) // whenever compiler sees no new keyword, it jumps straight inside apply method
// we can also write ws1("string", 1)
ws1.apply(76)

//ws1.name cannot access here as name is private