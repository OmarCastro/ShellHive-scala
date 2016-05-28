package shared.bash.commands

/**
 * @author Omar Castro <omar-a-castro@telecom.pt>, 07-05-2016.
 */
class EchoCommand(arguments:Arguments) extends Command(arguments:Arguments){
  val command = EchoCommand.commandName
}

object EchoCommand extends CommandBuilder {
  val commandName = "echo"
  override def buildCommand(arguments: Arguments): Command = new EchoCommand(arguments)
}

