package shared.api
import derive.key
/**
  * Created by Omar Castro on 12/06/2016.
  */
trait Api {
  def doThing(i: Int, s: String): Seq[String]
}

sealed trait WebSocketRequest[T]{
  def data: T
}

sealed trait WebSocketResponse[T]{
  def data: T
}

//a request that doesn't expect a response
@key("signal") case class WSSignal[T](data: T) extends WebSocketRequest[T] with WebSocketResponse[T]
//this class expects a response of type WSResponse
@key("request") case class WSRequest[T](@key("reqId") requestId: Long, data: T) extends WebSocketRequest[T]
@key("response") case class WSResponse[T](@key("reqId") requestId: Long, data: T) extends WebSocketResponse[T]