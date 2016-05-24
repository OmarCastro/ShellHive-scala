package shared.bash.parser


object BashParser{

  import Lexical._
  import fastparse.all._
  import shared.bash._

  private def joinChars(tree:(String,String)) = {
    tree._1+tree._2
  }

  private def initCommand(commandWithArgs:(String,Arguments)):Command = {
    val (command, arguments) = commandWithArgs
    Command.fromParse(command,arguments)
  }

  private def isValidCommand(commandName: String):Boolean = Command.isImplementedCommand(commandName)
 
    


  private val redirectTarget: P[String] = string
  /*private val redirect: = P(digit.? ~ outputType.! ~ redirectTarget.! )*/

  private val bashCommandName : P[String] = P(letter.! ~/ letterOrNumber.rep.!).map(joinChars).filter(isValidCommand)

  private val option: P[Argument] = P(CharIn("-").rep(max=2) ~/ string).map(new Argument.textArg(_))
  private val processSubstitutionIn: P[Argument.processSubstitutionTo] = P(">(" ~/ bashCommand ~/ ")").map(new Argument.processSubstitutionTo(_))
  private val processSubstitutionOut: P[Argument.processSubstitutionFrom] = P("<(" ~/ bashCommand ~/ ")").map(new Argument.processSubstitutionFrom(_))
  private val processSubstitution: P[Argument] = P(processSubstitutionIn | processSubstitutionOut)

  private val fileInput: P[Argument.redirect] = P("<" ~ " ".rep ~/ string.!).map((file: String) => Argument.redirect(Redirect.Input(file)))

  private val redirectOut: P[Argument.redirect] = P(">" ~ " ".rep ~ redirectTarget.!).map((file: String) => Argument.redirect(Redirect.Output(file)))
  private val redirectAppendOut: P[Argument.redirect] = P(">>"~ " ".rep  ~ redirectTarget.!).map((file: String) => Argument.redirect(Redirect.AppendOutput(file)))
  private val redirectErr: P[Argument.redirect] = P("2>"~ " ".rep  ~ redirectTarget.!).map((file: String) => Argument.redirect(Redirect.Error(file)))
  private val redirectAppendErr: P[Argument.redirect] = P("2>>" ~ " ".rep ~ redirectTarget.!).map((file: String) => Argument.redirect(Redirect.AppendError(file)))
  private val redirect : P[Argument.redirect] = P(redirectAppendErr | redirectErr | redirectAppendOut | redirectOut)

  private val bashArgument: P[Argument] = P( " ".rep(1) ~/ (processSubstitution | fileInput | redirect | option))

  private val bashCommand: P[Command] = P(" ".rep ~ bashCommandName.! ~ bashArgument.rep ~  " ".rep).map(initCommand)

  private val bashExpr: P[Command] = P(bashCommand ~ End)

  def parseCommandLine(commandLine: String): Parsed[Command] = {
    bashExpr.parse(commandLine)
  }
}