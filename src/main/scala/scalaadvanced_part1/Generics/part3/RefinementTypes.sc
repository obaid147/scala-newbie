trait Food{val name: String}
trait Fruit extends Food
trait Cereal extends Food

case class Apple(name: String) extends Fruit
case class Muesli(name: String) extends Cereal

val fiji = Apple("fiji")
val alpen = Muesli("alpen")

case class FoodBowlT[+F <: Food](item: F)
val appleBowl = FoodBowlT[Apple](fiji)
val muesliBowl = FoodBowlT[Muesli](alpen)

def feedToFruitEaterT(bowl: FoodBowlT[Fruit]) = s"yummy ${bowl.item.name}"
//We can now control what our fruit eater eats, the compile will not let us
//provide a bowl of Muesli:
feedToFruitEaterT(appleBowl)
//feedToFruitEater(muesliBowl) // type mismatch; found : FoodBowlT[Muesli] > required: FoodBowlT[Fruit]



//Can we achieve the same thing with type members?
abstract class FoodBowl {
  type FOOD <: Food
  val item: FOOD
}
class AppleBowl extends FoodBowl {
  type FOOD = Apple
  val item: Apple = fiji
}
class MuesliBowl extends FoodBowl {
  type FOOD = Muesli
  val item: Muesli = alpen
}
def feedToFruitEater(bowl: FoodBowl) = s"yummy ${bowl.item.name}"
feedToFruitEater(new AppleBowl)
feedToFruitEater(new MuesliBowl) // oops!!!
/**
 * Since both AppleBowl and MuesliBowl extend FoodBowl, both compile.
 * We want to prevent a fruit eater eating anything but Fruit.
 * But we don't want to restrict them to just Apples (e.g. AppleBowl).
 * How do we achieve it???
 * //We can limit the type of FoodBowl that is acceptable using a refinement type:
 */
def safeFeedToFruit(bowl: FoodBowl {type FOOD <: Fruit}) = s"Yummy ${bowl.item.name}"
safeFeedToFruit(new AppleBowl)
//safeFeedToFruit(new MuesliBowl) // Muesli is not a subtype of Fruit

/*
* Now our method specifies that only FoodBowls with a FOOD subtype of Fruit is acceptable.
* Because the inner type FOOD refines what is acceptable, we call this a *//***REFINEMENT Type*/