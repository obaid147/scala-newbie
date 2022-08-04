// Begin with creating a simple case class
/*case*/ class FullName(val first: String, val last: String)
//constructs and then deconstructs an instance of this case class

//val me = FullName("Obaid", "Fayaz") //Constructing
//val FullName(meFirst, meLast) = me // Deconstructing

// Removing the case keyword from class

// We add a companion object for the FullName class: to fix it

object FullName{
  def apply(first: String, last: String) = new FullName("obaid", "Fayaz")
  // when creating apply, val me = ... is fixed

  def unapply(full: FullName): Some[(String, String)] = {
    Some((full.first, full.last))
    // We also need to change parameter from private[This]
  }
}

/**
 * apply takes 2 Strings and returns an instance of FullName class.
 * unapply takes the instance of FullName class and returns two Strings wrapped in Option.
 */