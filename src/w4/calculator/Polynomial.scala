package w4.calculator

object Polynomial {
  def computeDelta(a: Signal[Double], b: Signal[Double],
      c: Signal[Double]): Signal[Double] = {
    val deltaVal = math.pow(b(), 2.0) - 4 * a() * c()
    Signal(deltaVal)
  }

  def computeSolutions(a: Signal[Double], b: Signal[Double],
      c: Signal[Double], delta: Signal[Double]): Signal[Set[Double]] = {
    val minusbVal = - b()
    val deltaSqrtVal = math.sqrt(delta())
    val twoaVal = 2*a()
    Signal {
      Set( (minusbVal + deltaSqrtVal) / twoaVal, (minusbVal - deltaSqrtVal) / twoaVal )
    }
  }
}
