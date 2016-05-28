package shared.bash

import shared.bash.commands._
/**
* @author Omar Castro <omar-a-castro@telecom.pt>, 07-05-2016.
*/
object Command {
  lazy val commands: collection.mutable.Map[String, CommandBuilder] = {
    val result = collection.mutable.Map[String, CommandBuilder]()
    result.put(CatCommand.commandName,CatCommand)
    result.put(EchoCommand.commandName,EchoCommand)
    result
  }

  def isImplementedCommand(commandName: String): Boolean = commands.contains(commandName)

  def fromParse(commandName: String, arguments:Arguments) : Command= {
    commands.get(commandName) match {
      case Some(i:CommandBuilder) => i.buildCommand(arguments)
      case None => null
    }
  }


}

abstract class Command(val arguments:Arguments) {

  def command: String

  def generateCommand(): String = s"$command ${arguments.foldLeft(""){(a, z:Argument) => s"$a ${z.printArgument}"}}"

  def renderHtml():String  ={
//    val elem = div(
//      cls := "component",
//      data("command") := command,
//      div(title := command,cls:="title",
//        command,
//        div(cls := "tooltip","Drag me to move me!")
//      ),
//        arguments.map((arg: Argument) => p(arg.printArgument))
//    ).render
//    elem
    s"""<component command="$command"></component>"""
  }

}