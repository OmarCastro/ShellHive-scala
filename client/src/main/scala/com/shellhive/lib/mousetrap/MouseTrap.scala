package com.shellhive.lib.mousetrap

object Mousetrap extends JsObject {
  def bind(keys : JsArray[JsString], fn : JsFunction1[MousetrapEvent, Boolean]) : JsAny = scala.scalajs.js.native
  def bind(key : String, fn : JsFunction1[MousetrapEvent, Boolean]) : JsAny = scala.scalajs.js.native
}

trait MousetrapEvent extends JsObject
