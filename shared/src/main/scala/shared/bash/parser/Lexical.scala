package shared.bash.parser

/**
 * @author Omar Castro <omar-a-castro@telecom.pt>, 08-05-2016.
 */
private[parser] object Lexical {
  import fastparse.all._

  val Whitespace = " \r\n".contains(_: Char)
  val space         = P( CharsWhile(Whitespace).? )

  val singleQuoteString: P[String] = P("'" ~ CharsWhile(_ != '\'').! ~ "'")
  val noQuoteString: P[String] = P(CharsWhile(!" )".contains(_: Char)).!)

  val string: P[String] = P(singleQuoteString | noQuoteString)

  val shortstring: P[String] = P( shortstring0("'") | shortstring0("\"") )
  def shortstring0(delimiter: String) = P( delimiter ~ shortstringitem(delimiter).rep.! ~ delimiter)
  def shortstringitem(quote: String): P0 = P( shortstringchar(quote) | escapeseq )
  def shortstringchar(quote: String): P0 = P( CharsWhile(!s"\\\n${quote(0)}".contains(_)) )

  val escapeseq: P0 = P( "\\" ~ AnyChar )

  val letterOrNumber     = P( lowercase | uppercase | digit )
  val letter     = P( lowercase | uppercase )
  val lowercase  = P( CharIn('a' to 'z') )
  val uppercase  = P( CharIn('A' to 'Z') )
  val digit      = P( CharIn('0' to '9') )
}
