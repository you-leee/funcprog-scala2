package w4.practice.latencyandfuture

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._
import scala.util.{Failure, Success}

/**
  * Created by U539852 on 2017.01.17..
  */
trait Socket[T] {
  def readFromMemory(): Future[T]
  def send(packet: T): Future[T]

  def retry(noTimes: Int)(block: => Future[T]): Future[T] = {
    if(noTimes == 0) Future.failed(new Exception("max number of tries reached"))
    else block fallbackTo {
      retry(noTimes - 1)(block)
    }
  }

  def retryWithFold(noTimes: Int)(block: =>Future[T]): Future[T] = {
    val ns = (1 to noTimes).toList
    val attempts = ns.map(_ => () => block)
    val failure = Future.failed( new Exception("max number of tries reached") )
    val result = attempts.foldLeft(failure)((a,block) => a recoverWith {case _ =>  block()})
    result
  }
}

object Socket extends Socket[String] {
  val memory = Array[String](
    "message1", "message2"
  )

  def readFromMemory(): Future[String] = Future {
    memory reduce (_.concat(_))
  }

  def send(packet: String): Future[String] = Future(packet)


}


