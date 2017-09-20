package w4.practice.Observer

/**
  * Created by U539852 on 2017.01.17..
  */
//Observable/model
class BankAccount extends Publisher {
  private var balance = 0

  def currentBalance(): Int = balance

  def deposit(amount: Int): Unit = {
    if(amount > 0) {
      balance += amount
      publish()
    }
  }

  def withdraw(amount: Int): Unit = {
    if(amount > 0 && balance >= amount) {
      balance -= amount
      publish()
    } else {
      throw new Error("insufficient funds")
    }
  }

}
