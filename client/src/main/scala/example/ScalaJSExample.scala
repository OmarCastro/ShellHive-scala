package example

import com.shellhive.angular.components.{TipDirective, CommandComponent}

import scala.scalajs.js
import org.scalajs.dom
import shared.SharedMessages
import shared.bash.parser.BashParser
import fastparse.all.Parsed
import scalatags.JsDom.all._
import biz.enef.angulate._

object ScalaJSExample extends js.JSApp {
  def main(): Unit = {
    val textInput:dom.html.Input = dom.document.getElementById("parserOutput").asInstanceOf[dom.html.Input];
    
    dom.document.getElementById("scalajsShoutOut").textContent = SharedMessages.itWorks
    textInput.oninput = (event: dom.Event) => {
      parseBash(textInput.value,dom.document.getElementById("parserShoutOut"))
    }
    parseBash("teste >(asd)",dom.document.getElementById("parserShoutOut"))
    
  }

  val module = angular.createModule("foo")
  module.componentOf[CommandComponent]
  module.directiveOf[TipDirective]

  val spanElems: dom.NodeList = dom.document.querySelectorAll(".parse-test")

  dom.ext.PimpedNodeList(spanElems).foreach((node:dom.Node) => {
    val root = node.asInstanceOf[dom.html.Div]
    val input = root.querySelector(".input")
    val commandLine = input.getAttribute("data-input")
    input.textContent = commandLine
    val result = root.querySelector(".result")
    parseBash(commandLine,result)

  })



  val testTableRow = dom.ext.PimpedNodeList(dom.document.querySelectorAll("tr[data-command]"))
  testTableRow.foreach((node:dom.Node) => {
    val root = node.asInstanceOf[dom.html.TableRow]
    val commandLine = root.getAttribute("data-command")
    root.appendChild(td(commandLine).render)

    BashParser.parseCommandLine(commandLine) match {
      case Parsed.Success(command, _) =>
        val resultObj = s"""command "${command.command}" with arguments ${command.arguments} """
        root.appendChild(td(resultObj).render)
        val htmlTd = td.render
        htmlTd.innerHTML = command.renderHtml()
        root.appendChild(htmlTd)
        root.appendChild(td(command.generateCommand()).render)

      case Parsed.Failure(parser, index, extra) =>
        val resultObj = s"error at column ${extra.col}: ${extra.input.substring(extra.col -1,extra.col +1)}"
        root.appendChild(td(resultObj).render)
        root.appendChild(td().render)


    }
  })
  
  def parseBash(text:String, elem: dom.Element) = {
    elem.textContent = {
      BashParser.parseCommandLine(text) match {
        case Parsed.Success(command, _) => s"""command "${command.command}" with arguments ${command.arguments} """
        case Parsed.Failure(parser, index, extra) => s"error at column ${extra.col}: ${extra.input.substring(extra.col -1,extra.col +1)}"
      }
    }
  }
}