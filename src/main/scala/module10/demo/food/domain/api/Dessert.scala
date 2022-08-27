//package module10.demo.food.domain.api
// idiomatic way
//trait Dessert{
//  def isCheap: Boolean
//}

//Alternative 1 C# way

//package module10{
//  package demo{
//    package food{
//      package domain{
//        package api{
//          trait Dessert{
//            def isCheap: Boolean
//          }
//        }
//      }
//    }
//  }
//}

//Alternative 2 namespace shorthand--- Namespace notation
package module10.demo.food.domain.api{
  trait Dessert{
    def isCheap: Boolean
  }
}
