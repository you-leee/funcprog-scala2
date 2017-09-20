package w4.practice.Observer

/**
  * Created by U539852 on 2017.01.17..
  */
// Observable
trait Publisher {
  private var subscribers: Set[Subscriber] = Set()

  def subscribe(subscriber: Subscriber): Unit = subscribers += subscriber
  def unSubscribe(subscriber: Subscriber): Unit = subscribers -= subscriber
  def publish(): Unit = subscribers.foreach(_.handler(this))
}
