package controllers


import javax.inject.Inject

import akka.actor._
import akka.stream.Materializer
import play.api.mvc._
import play.api.libs.streams._
import autowire._
import upickle.default._
import shared.api.{Api, WSRequest, WSResponse}

import scala.concurrent.ExecutionContext.Implicits.global

class WebSocketCtrl @Inject() (implicit system: ActorSystem, materializer: Materializer) {

  def socket = WebSocket.accept[String, String] { request =>
    ActorFlow.actorRef(out => MyWebSocketActor.props(out))
  }
}

object MyApiImpl extends Api{
  def doThing(i: Int, s: String) = Seq.fill(i)(s)
}

object MyServerApi extends Server[String, Reader,Writer]{
  def write[Result: Writer](r: Result) = upickle.default.write(r)
  def read[Result: Reader](p: String) = upickle.default.read[Result](p)
  val routes = MyServerApi.route[Api](MyApiImpl)
}


object MyWebSocketActor {
  def props(out: ActorRef) = Props(new MyWebSocketActor(out))
}

class MyWebSocketActor(out: ActorRef) extends Actor {
  def receive = {
    case msg: String =>
      val request = upickle.default.read[WSRequest[MyServerApi.Request]](msg)
      MyServerApi.routes.apply(request.data).foreach((value) => out ! upickle.default.write(WSResponse(request.requestId,value)))
  }
}