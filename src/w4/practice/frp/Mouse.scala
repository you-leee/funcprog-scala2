package w4.practice.frp

/**
  * Created by U539852 on 2017.01.17..
  */
class Mouse {
  type Position = Int
  val mousePosition = Var(0)

  def isRectangle(LL: Position, UR: Position): Signal[Boolean] = {
    Signal {
      val pos = mousePosition()
      LL <= pos && pos <= UR
    }
  }

  def moveTo(newPos: Position): Unit = {
    mousePosition() = newPos
  }
}
