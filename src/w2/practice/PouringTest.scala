package w2.practice

/**
  * Created by U539852 on 2017.01.12..
  */
object PouringTest extends App{
  val problem = new Pouring(Vector(4, 9, 19))
  println(problem.moves)

  println(problem.pathSets.take(3).toList)

  println(problem.solutions(17))
}
