package w4.practice.Observer

/**
  * Created by U539852 on 2017.01.17..
  */
trait Subscriber {
  def handler(pub: Publisher)
}
