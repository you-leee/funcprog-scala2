package w3.practice.DES

/**
  * Created by U539852 on 2017.01.16..
  */
object Test extends App {
  println("Welcome to the Scala worksheet")
  object sim extends Circuits with Parameters
  import sim._

  val in1, in2, sum, carry = new Wire
  halfAdderAlt(in1, in2, sum, carry)
  probe("sum", sum)
  probe("carry", carry)

  in1 setSignal true
  run()

  in2 setSignal true
  run()

  in1 setSignal false
  run()
}
