package w4.practice.frp

/**
  * Created by U539852 on 2017.01.17..
  */
class BankAccount {
  val balance = Var(0)

  def deposit(amount: Int): Unit = {
    if(amount > 0) {
      val currentBalance = balance()
      balance() = currentBalance + amount
    }
  }

  def withdraw(amount: Int): Unit = {
    if(amount > 0 && balance() >= amount) {
      val currentBalance = balance()
      balance() = currentBalance - amount
    } else {
      throw new Error("unsufficient founds")
    }
  }

}
