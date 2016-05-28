package shared.bash.commands

/**
 * @author Omar Castro <omar-a-castro@telecom.pt>, 07-05-2016.
 */
class CatCommand(arguments:Arguments) extends Command(arguments:Arguments){
  val command = CatCommand.commandName

  override def renderHtml():String  ={
    s"""<component command="$command" real-cat>${fileInputs()}</component>"""
  }

  def fileInputs(): String ={
     arguments.foldLeft("")((aggregator:String, argument: Argument) => s"""$aggregator<input type="text" filename="$argument"/>""")
  }
}

object CatCommand extends CommandBuilder {
  val commandName = "cat"
  override def buildCommand(arguments: Arguments): Command = new CatCommand(arguments)


}
