package w3.practice

/**
  * Created by U539852 on 2017.01.16..
  */
object BankAccountMain extends App {
    val acct = new w3.practice.BankAccount
    acct deposit 50
    println(acct withdraw 20)
    println(acct withdraw 20)
    println(acct withdraw 15)
}
