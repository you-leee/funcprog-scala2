package w1.practice

import java.util.Random

/**
  * Created by U539852 on 2017.01.10..
  */
object Generator {

  trait Generator[+T] {
    self =>

    def generate: T

    def map[S](f: T => S): Generator[S] = new Generator[S] {
      def generate = f(self.generate)
    }

    def flatMap[S](f: T => Generator[S]): Generator[S] = new Generator[S] {
      def generate = f(self.generate).generate
    }
  }

  val integers = new Generator[Int] {
    val rand = new Random()
    def generate: Int = rand.nextInt()
  }

  val booleans = integers map (_ > 0)

  def pairs[T, U](t: Generator[T], u:Generator[U]) = new Generator[(T, U)] {
    def generate = (t.generate, u.generate)
  }

  def single[T](x: T): Generator[T] = new Generator[T] {
    def generate: T = x
  }

  def choose(lo: Int, hi: Int): Generator[Int] = {
    integers map (x => lo + x % (hi - lo))
  }

  def oneOf[T](xs: T*): Generator[T] = {
    choose(0, xs.length) map (idx => xs(idx))
  }

  // Randomly generated list
  def lists: Generator[List[Int]] = for {
    isEmpty <- booleans
    list <- if(isEmpty) emptyLists else nonEmptyLists
  } yield list

  def emptyLists = single(Nil)
  def nonEmptyLists = for {
    head <- integers
    tail <- lists
  } yield head :: tail


  // Randomly generated Trees
  trait Tree
  case class Inner(left: Tree, right: Tree) extends Tree
  case class Leaf(x: Int) extends Tree

  def leafs: Generator[Leaf] = for {
    x <- integers
  } yield Leaf(x)

  def inners: Generator[Inner] = for {
    l <- trees
    r <- trees
  } yield Inner(l, r)

  def trees: Generator[Tree] = for {
    isLeaf <- booleans
    tree <- if(isLeaf) leafs else inners
  } yield tree



  // Random testing
  def test[T](g: Generator[T], numTimes: Int = 100)(test: T => Boolean): Unit = {
    for(i <- 1 to numTimes) {
      val value = g.generate
      assert(test(value), "test failed for " + value)
    }
    println("passed " + numTimes + " tests")
  }
}
