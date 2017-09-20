import w4.practice.latencyandfuture.Socket

import scala.concurrent._
import scala.util.{Failure, Success}
import scala.concurrent.ExecutionContext.Implicits.global

val socket = Socket
val packet = socket.readFromMemory()
val confirmation: Future[String] =
  packet.flatMap(p => socket.send(p))
println(confirmation)
