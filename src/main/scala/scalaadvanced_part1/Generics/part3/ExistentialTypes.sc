import language.existentials

/**
 * If type parameters are specified in definition, they must be provided in implementation
When using a parameterized type in a method or definition, you cannot skip the parameter:*/
//def lengthOfList(xs: List): Int = xs.length//>class List takes type parameters

/**We could use a generic to satisfy it:*/
def lengthOfList[T](xs: List[T]): Int = xs.length
/**But we don't use T anywhere or care what it is in this case*/


/**Existential Types:- let's us skip the definition of type parameters*/
def lengthOfListExistential(xs: List[T forSome {type T}]): Int = xs.length
def lengthOfListSimple(xs: List[_]): Int = xs.length // because type exists at Runtime

/**Bounding Existential Types*/
trait Food{val name: String}
trait Fruit extends Food
def fruitNames1[T <: Fruit](fruits: List[T]) = fruits.map(_.name)
def fruitNames2(fruits: List[T forSome {type T <: Fruit}]) = fruits.map(_.name)
def fruitNames3(fruits: List[_ <: Fruit]) = fruits.map(_.name)
/*In fruitNames1,2&3 we can use .name because we know it is a Fruit subtype.
* Only with full generic form, We can use T for other parameters or for a return type*/