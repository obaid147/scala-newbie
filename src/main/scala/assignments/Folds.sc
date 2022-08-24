case class Endorsement(name: String, skill: String)

val endorsements = List(
  Endorsement("Bob", "JS"), Endorsement("David", "JS"),
  Endorsement("Bob", "HTML"), Endorsement("James", "HTML"),
  Endorsement("James", "JS"), Endorsement("James", "CSS")
)
case class FinalResult(skill: String,
                       people: List[String], count: Int)

//Map("JS" -> List("Bob", "David", "James"), "html" -> List("Bob", "james"), "CSS" -> List("James"))
//Map("JS" -> List("Bob", "David"))
/*val m = Map()
val r: List[FinalResult] = m.map {case  (k, v) =>
  FinalResult(k, v, v.length)
}.toList*/

def process(list: List[Endorsement]): List[FinalResult] = {
  list.foldLeft(Map[String, List[String]]()){ (acc, item) =>
    if(acc.contains(item.skill)) {
      val existingPeople: List[String] = acc(item.skill)
      val newPeople: List[String] =  item.name :: existingPeople
      acc + (item.skill -> newPeople)
    } else {
      acc + (item.skill -> List(item.name))
    }
  }.toList.map { tup =>
    FinalResult(tup._1, tup._2, tup._2.length)
  }

}

val res = process(endorsements)

// -------------------------------------------------------
case class Person(name: String, gender: String)

val personList = List(
  Person("aamir", "male"),
  Person("nighat", "female"),
  Person("obaid", "male")
)

case class TitledPerson(titledPerson: String)

def processingPerson(list: List[Person]): List[TitledPerson] = {
  list.foldLeft(List[String]()) { (acc, item) =>

    val gender = if (item.gender == "male") "Mr" else "Mrs"
    acc :+ s"$gender ${item.name}"
  }.map { x =>
    TitledPerson(x.split(",").mkString("", ", ", ""))
  }
}
processingPerson(personList)
/*
List(
TitledPerson("Mr", "aamir"),
TitledPerson("Mrs", "Nighat"),
TitledPerson("Mr", "obaid")
)*/
/*TitledPerson(x.split(" ").mkString("Array(", ", ", ")"),
      x.split(",").mkString("Array(", ", ", ")"))*/


/** change from type String to Int
 * Also uses seed value "IF collection was empty"*/
val l: List[String] = List("abc", "def", "ghi")
val res: Int = l.foldLeft(0){ (acc, item) => acc + item.length}

val f: (String, String) => String = (x, y) => x + y
l.reduceLeft(f)

l.reduceLeft(_ + _)

//def reduceLeft(f: (A, A) => A): A*/

/*val m1 = Map(1 -> "one")

val m2 = Map(2 -> "two")

val m3 = m1 ++ m2

m3 ++ Map(1 -> "oneeeee")

val list: List[Int] = List(1, 1, 1, 1)
val listOfMap: List[Map[String, Int]]= List(Map("a" -> 1), Map("a" -> 2))
def addN(list: List[Int], n: Int) = list.map(_+n)

val result = listOfMap.foldLeft(list)((x, y) => addN(x, y("a")))
*/
