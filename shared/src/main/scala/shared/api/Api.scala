package shared.api

/**
  * Created by Omar Castro on 12/06/2016.
  */
trait Api {
  def doThing(i: Int, s: String): Seq[String]
}


sealed trait WebSocketRequest[T]{
  def requestId: Long
  def data: T
}

case class WSReqWithoutResponse[T](requestId: Long, data: T) extends WebSocketRequest[T]
case class WSReqWithResponse[T](requestId: Long, data: T) extends WebSocketRequest[T]
case class WSResponse[T](requestId: Long, data: T)