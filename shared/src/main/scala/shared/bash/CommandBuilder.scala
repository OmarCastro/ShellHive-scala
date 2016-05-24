package shared.bash

/**
 * @author Omar Castro <omar-a-castro@telecom.pt>, 07-05-2016.
 */
trait CommandBuilder{
  def commandName: String
  def buildCommand(arguments:Seq[Argument]) : Command
}
