package w3.practice

/**
  * Created by U539852 on 2017.01.16..
  */
class BankAccount {
  private var balance = 0
  def deposit(amount: Int): Int = {
    if(amount > 0) balance += amount; balance
  }
  def withdraw(amount: Int): Int = {
    if(amount > 0 && balance >= amount) {
      balance -= amount
      balance
    } else {
      throw new Error("insufficient funds")
    }
  }
}
