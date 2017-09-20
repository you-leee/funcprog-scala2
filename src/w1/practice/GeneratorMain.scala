package w1.practice

/**
  * Created by U539852 on 2017.01.10..
  */
object GeneratorMain extends App {
  println(Generator.trees.generate)

  Generator.test(Generator.pairs(Generator.lists, Generator.lists)) {
    case(xs, ys) => (xs ++ ys).length >= xs.length
  }

}
