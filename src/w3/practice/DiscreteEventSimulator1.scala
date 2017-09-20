package w3.practice

/**
  * Created by U539852 on 2017.01.16..
  */
class DiscreteEventSimulator1 {
  class Wire{
    var state = false
  }

  def inverter(input: Wire, output: Wire): Unit = {
    output.state = !input.state
  }
  def andGate(a1: Wire, a2:Wire, output: Wire): Unit = {
    output.state = a1.state & a2.state
  }
  def orGate(o1: Wire, o2:Wire, output: Wire): Unit = {
    output.state = o1.state | o2.state
  }

  def halfAdder(a: Wire, b: Wire, s: Wire, c: Wire): Unit = {
    val d = new Wire
    val e = new Wire
    orGate(a, b, d)
    andGate(a, b, c)
    inverter(c, e)
    andGate(d, e, s)
  }

  def fullAdder(a: Wire, b: Wire, cin: Wire, sum: Wire, cout: Wire): Unit = {
    val s = new Wire
    val c1 = new Wire
    val c2 = new Wire
    halfAdder(b, cin, s, c1)
    halfAdder(a, s, sum, c2)
    orGate(c2, c1, cout)
  }
}
