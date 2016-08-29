package com.shellhive.i18n

import scala.scalajs.js
import org.scalajs.dom

/**
  * Facade type of Play Messages <a href="https://github.com/ccampbell/mousetrap">MouseTrap</a> library
  */
object Messages extends js.Object {
  def apply(i18nLang:String)(key:String): String = scala.scalajs.js.native

}

object i18nMessages {
  val getDefaultLang: String = dom.document.querySelector("html").getAttribute("lang")
}

class i18nMessages(val key: String) {
  def translate(): String = Messages(i18nMessages.getDefaultLang)(key)
  def translate(i18nLang:String): String = Messages(i18nLang)(key)


}

