package w1.practice

import org.scalacheck.Properties
import org.scalacheck.Prop.forAll

/**
  * Created by U539852 on 2017.01.10..
  */
object ListSpecification extends Properties("List"){
  property("length") = forAll {
    (a: List[Int], b: List[Int]) => (a ++ b).length >= a.length
  }

  property("length equality") = forAll {
    (a: List[Int], b: List[Int]) => (a ++ b).length == a.length + b.length
  }
}
