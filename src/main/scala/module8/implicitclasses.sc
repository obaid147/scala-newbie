/*class MyOwnStringClass extends String {

  def containsVowel(s: String): Boolean = ???
}*/

/**
  Extension method, type enrichment
  -- extending the functionality of a class without using inheritance or modifying original library source code
 */
 // object abcdefSyntax
object StringSyntax {
    //class abcOps
   //  class StringOps(s: String) {
    implicit class StringOps(s: String)  {
      def containsVowel: Boolean = if(s.contains("a") || s.contains("b")) true else false
    }
}

val string = "aamir"

import StringSyntax._
// new StringOps(string).containVowel
"aamir".containsVowel
string.containsVowel
