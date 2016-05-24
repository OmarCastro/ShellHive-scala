package shared.bash


/**
 * @author Omar Castro <omar-a-castro@telecom.pt>, 08-05-2016.
 */
package object commands {

  type Argument = shared.bash.Argument
  type Command = shared.bash.Command
  type CommandBuilder = shared.bash.CommandBuilder
  type Arguments = Seq[Argument]
}
