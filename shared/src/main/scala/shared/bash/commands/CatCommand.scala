package shared.bash.commands

/**
 * @author Omar Castro <omar-a-castro@telecom.pt>, 07-05-2016.
 */
class CatCommand(arguments:Arguments) extends Command(arguments:Arguments){
  val command = CatCommand.commandName
}

object CatCommand extends CommandBuilder {
  val commandName = "cat"
  override def buildCommand(arguments: Arguments): Command = new CatCommand(arguments)
}
