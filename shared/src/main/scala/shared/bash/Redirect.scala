package shared.bash

/**
 * @author Omar Castro <omar-a-castro@telecom.pt>, 07-05-2016.
 */
object Redirect {
  case class Input(fileName: String) extends Redirect{ val sign = "<"}
  case class Output(fileName: String) extends Redirect{ val sign = ">"}
  case class AppendOutput(fileName: String) extends Redirect{ val sign = ">>"}
  case class Error(fileName: String) extends Redirect{ val sign = "2>"}
  case class AppendError(fileName: String) extends Redirect{ val sign = "2>>"}
}

trait Redirect {
  def sign: String
  def fileName: String
  def printArgument() : String = s"$sign $fileName"
}