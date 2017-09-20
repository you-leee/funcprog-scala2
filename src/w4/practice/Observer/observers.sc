import w4.practice.Observer.BankAccount
import w4.practice.Observer.Consolidator

val a = new BankAccount
val b = new BankAccount
b deposit 30
val c = new Consolidator(Set(a,b))

c totalBalance

a deposit 200
c totalBalance

b deposit 30
a withdraw 20
c totalBalance

