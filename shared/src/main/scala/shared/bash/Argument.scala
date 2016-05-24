package shared.bash

/**
 * @author Omar Castro <omar-a-castro@telecom.pt>, 07-05-2016.
 */
object Argument {
  case class processSubstitutionTo(command: Command) extends Argument { val printArgument = s">( ${command.generateCommand()} )" }
  case class processSubstitutionFrom(command: Command) extends Argument { val printArgument = s"<( ${command.generateCommand()} )" }
  case class redirect(redirect: Redirect) extends Argument  { val printArgument = redirect.printArgument }
  case class textArg(arg: String) extends Argument  { val printArgument = arg }
  case class shortArguments(arg: String) extends Argument { val printArgument = arg }
  case class longArgument(arg: String) extends Argument { val printArgument = arg }
}

/**
 * @author Omar Castro <omar-a-castro@telecom.pt>, 03-05-2016.
 */
trait Argument {
  def printArgument: String
}