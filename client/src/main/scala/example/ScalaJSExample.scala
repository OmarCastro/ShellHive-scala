package example

import com.shellhive.angular.components.{GraphDirective, MouseTrapDirective, TipDirective}

import scala.scalajs.js
import org.scalajs.dom
import org.scalajs.dom.raw._
import com.shellhive.i18n._
import shared.bash.parser.BashParser
import fastparse.all.Parsed
import upickle.default._
import autowire._
import shared.api.Api
import scalatags.JsDom.all._
import biz.enef.angulate._
import com.shellhive.angular.components.nodes.{ComponentDirective, ComponentTitleDirective}
import scala.concurrent.ExecutionContext.Implicits.global

object ScalaJSExample extends js.JSApp {
  def main(): Unit = {

    val socket = new dom.WebSocket(js.Dynamic.global.jsRoutes.controllers.WebSocketCtrl.socket().webSocketURL().toString)
    println(js.Dynamic.global.jsRoutes.controllers.WebSocketCtrl.socket().webSocketURL());

    socket.onopen = (event: Event) => {
      println("open")
      util.WebSocketsAutowireClient(socket)[Api].doThing(3,"mimi").call().onComplete((result) => {
        println("done")
        println(result)
      })
    }



    
  }

  val module = angular.createModule("foo")
  module.directiveOf[ComponentDirective]("component")
  module.directiveOf[TipDirective]("tip")
  module.directiveOf[GraphDirective]("graph")
  module.directiveOf[MouseTrapDirective]("mousetrap")
  module.directiveOf[ComponentTitleDirective]("componentTitle")

  val spanElems: dom.NodeList = dom.document.querySelectorAll(".parse-test")


  println(i18n.help.componentMove.tooltip.translate("pt"))
  
  def parseBash(text:String, elem: dom.Element) = {
    elem.textContent = {
      BashParser.parseCommandLine(text) match {
        case Parsed.Success(command, _) => s"""command "${command.command}" with arguments ${command.arguments} """
        case Parsed.Failure(parser, index, extra) => s"error at column ${extra.col}: ${extra.input.substring(extra.col -1,extra.col +1)}"
      }
    }
    }






}
