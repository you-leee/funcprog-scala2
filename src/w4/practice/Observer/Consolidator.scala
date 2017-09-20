package w4.practice.Observer

/**
  * Created by U539852 on 2017.01.17..
  */
// Observer/view
class Consolidator(observed: Set[BankAccount]) extends Subscriber {
  observed.foreach(_.subscribe(this))

  private var total: Int = _
  compute()

  def handler(pub: Publisher): Unit = compute()

  def compute() = {
    total = observed.map(_.currentBalance()).sum
  }

  def totalBalance = total
}
