package com.shellhive.angular.components

import biz.enef.angulate._
import scalajs.js
/**
 * @author Omar Castro <omar-a-castro@telecom.pt>, 08-05-2016.
 */
@Component(ComponentDef(
  selector = "component",
  template = """
>"""
))
class CommandComponent {


  var commandName = ""

  var title = js.Dictionary(
    "name" -> "ss",
    "buttons" -> true
  )

  def command = ???
  // called with the value of the DOM attribute 'init'
  def command_=(s: String) = {
    commandName = s
  }

  var showTooltip = false



  var status = js.Dictionary(
    "noTooltip" -> false
  )

  def transformScale() = 1
}




