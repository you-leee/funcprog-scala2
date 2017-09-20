package w4.practice.frp

/**
  * Created by U539852 on 2017.01.17..
  */
import w4.practice.frp

object FrpMain extends App {
  def consolidated(bs: BankAccount*): Signal[Int] = {
    Signal(bs.map(_.balance()).sum)
  }

  val a = new BankAccount
  val b = new BankAccount
  val c = consolidated(a, b)
  println(c())

  b deposit 20
  a deposit 30
  println(c())

  val xchange = Signal(24.5)
  val inDollar = Signal(xchange() * c())
  println(inDollar())

  a deposit 20
  println(inDollar())

  // Mouse
  val m = new Mouse
  val isInRectangle = m.isRectangle(1,6)
  println(isInRectangle())
  m.moveTo(5)
  println(isInRectangle())

  val n = new Mouse
  val isInRectangle2 = n.isRectangle(1,2)
  n.moveTo(m.mousePosition())
  println(isInRectangle2())
  n.moveTo(7)
  println(isInRectangle())
  println(isInRectangle2())
}



