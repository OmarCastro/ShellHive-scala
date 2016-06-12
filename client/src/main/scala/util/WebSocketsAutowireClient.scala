package util


import scala.concurrent.Future
import org.scalajs.dom
import upickle.default._

import scala.concurrent._
import ExecutionContext.Implicits.global
import autowire._
import org.scalajs.dom.raw.MessageEvent
import shared.api.{WSReqWithResponse, WSResponse}

import scala.util.Try

// When using this, don't forget to import autowire._ even though it doesn't seem like it's needed
trait WebSocketsAutowireClient extends autowire.Client[String, upickle.default.Reader, upickle.default.Writer]{
  def write[Result: Writer](r: Result) = upickle.default.write(r)
  def read[Result: Reader](p: String) = upickle.default.read[Result](p)
  // Needs trailing slash
  def socket: dom.WebSocket




  override def doCall(req: Request): Future[String] = {
    WebSocketsAutowireClient.id = WebSocketsAutowireClient.id +1
    val newPromise = Promise[String]
    WebSocketsAutowireClient.promises.put(WebSocketsAutowireClient.id,newPromise)
    socket.send(upickle.default.write(new WSReqWithResponse[Request](WebSocketsAutowireClient.id,req)))
    newPromise.future
  }

}
object WebSocketsAutowireClient {
  var id : Long = 0
  val promises = scala.collection.mutable.Map[Long,Promise[String]]()



  def apply(webSocket: dom.WebSocket): WebSocketsAutowireClient = new WebSocketsAutowireClient {
    val socket = webSocket

    socket.onmessage = (message: MessageEvent) => {

      println(message.data)
      val result = upickle.default.read[WSResponse[String]](message.data.toString)
      println(result)
      println(promises)
      promises.get(result.requestId) match {
        case Some(promise) =>
          println("reponse complete")
          promise.complete(Try(result.data.toString))
          promises.remove(result.requestId)
        case None => println("reponse failed")
      }
    }

  }
}