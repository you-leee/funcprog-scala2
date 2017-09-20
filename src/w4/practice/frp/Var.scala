package w4.practice.frp

/**
  * Created by U539852 on 2017.01.17..
  */
class Var[T](expr: => T) extends Signal[T](expr){
  override def update(expr: => T): Unit = super.update(expr)
}

object Var {
  def apply[T](expr: => T) = new Var(expr)
}
