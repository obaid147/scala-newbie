import scala.annotation.implicitNotFound

/**
 * In ImplicitObjectsAndMethods.sc
 * We came to know def's can also be implicit but with a useful feature ie:-
 * Methods can take parameters but
 * Implicit methods can take only implicit parameters because it's doing an Implicit......
 * BUT =====> IF implicit method parameters are also implicit,
 * Scala will look them up and fill them in as well.
 *
 * This leads us to Composability.
 * */

/* Any to JSON (JSONIFY)*/
@implicitNotFound("You need to define a JSONWrite for ${T}")
trait JSONWrite[T] {
  def toJsonString(item: T): String
}

def jsonify[T: JSONWrite](item: T): String = {
  implicitly[JSONWrite[T]].toJsonString(item)
}


/*Json Write for Strings*/
implicit object StrJsonWrite extends JSONWrite[String] {
  override def toJsonString(item: String): String = s""""$item""""
}

println(jsonify("hello"))
//println(jsonify(2.0)) No implicit found for jsonWriter[Double]

/*Json Write for Doubles*/
implicit object DoubleJsonWrite extends JSONWrite[Double] {
  override def toJsonString(item: Double): String = item.toString
}
println(jsonify(2.0))


/**Jsonify a List[T]*/
//implicit object ListJsonWrite extends JsonWriter[List[T]] // cannot use T
implicit def listJSONWrite[T: JSONWrite] = new JSONWrite[List[T]] {
  def toJsonString(xs: List[T]) = {
    xs.map(x => jsonify(x)).mkString("[", " ,", "]")
  }
}

val strList = List("Hey", "there")
val doubleList = List(1.1, 2.1, 3.1)
//val intList = List(1, 2, 3) // No implicit found for type JSONWrite[List[Int]]

jsonify(strList)
jsonify(doubleList)

/*Json Write for Int*/
implicit object IntJSONWrite extends JSONWrite[Int] {
  override def toJsonString(item: Int) = item.toString
}

val intList = List(1, 2, 3)
jsonify(intList)


/** Jsoniy a Map */
implicit def mapJSONWrite[T: JSONWrite]: JSONWrite[Map[String, T]] = new JSONWrite[Map[String, T]] {
  override def toJsonString(item: Map[String, T]) = {
    val pair = for ((k,v) <- item) yield
      s"${jsonify(k)}: ${jsonify(v)}"

    pair.mkString("{\n ", ",\n ", "\n}")
  }
}

println(jsonify(Map("one" -> 1, "two" -> 2)))

/** Map of Lists */
println(jsonify(Map("hello" -> List("Hello", "World"),
  "hey" -> List("Hey", "how", "are", "you"))))

/**
 * This is still limited to a single map value type that must have a JSONWrite.
 * More sophisticated implementations work around this with intermediate types
    * and other machinery.
 * See spray-json, upickle, play-json and numerous, multitudinous other
    * implementations of JSON libraries for more details.
 * At the core of each of these is this same compositional behavior.
 * */