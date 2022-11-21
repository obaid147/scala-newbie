/**TypeClasses.sc*/

/*

* We can now call genSort for any type as long as we define CompareT regardless of inheritance.

* Even for types we don't own (and couldn't add CompareT to the supertypes).

* So we can effectively add behavior to types without needing to extend other types.

* This capability is known as ad-hoc polymorphism.

*Scala is even more powerful in that you can choose which implicits will be imported/used.

*/
