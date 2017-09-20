package w2.practice

/**
  * Created by U539852 on 2017.01.10..
  */
object IntSets {
  abstract class IntSet {
    def incl(x: Int): IntSet
    def contains(x: Int): Boolean
    def union(other: IntSet): IntSet
  }

  object Empty extends IntSet {
    def incl(x: Int): IntSet = NonEmpty(x, Empty, Empty)

    def contains(x: Int): Boolean = false

    def union(other: IntSet): IntSet = other
  }

  case class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
    def incl(x: Int): IntSet = {
      if(x < elem) NonEmpty(elem, left.incl(x), right)
      else if(x > elem) NonEmpty(elem, left, right.incl(x))
      this
    }

    def contains(x: Int): Boolean = {
      if(x < elem) left.contains(x)
      else if(x > elem) right.contains(x)
      else true
    }

    def union(other: IntSet): IntSet = {
      (left union (right union other)) incl elem
    }
  }
}
