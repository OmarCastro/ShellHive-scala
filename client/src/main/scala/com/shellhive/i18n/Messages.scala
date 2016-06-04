package com.shellhive.i18n

import scala.scalajs.js


/**
  * Facade type of Play Messages <a href="https://github.com/ccampbell/mousetrap">MouseTrap</a> library
  */
object Messages extends js.Object {
  def apply(i18nLang:String)(key:String): String = scala.scalajs.js.native

}

class i18nMessages(val key: String) {
  def translate(i18nLang:String): String = Messages(i18nLang)(key)
}

