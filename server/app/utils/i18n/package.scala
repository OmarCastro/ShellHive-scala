package utils

import shared.i18n.I18n

/**
  * Created by Omar Castro on 05/06/2016.
  */
package object i18n {
  implicit def i18nToMessages(i18n: I18n):i18nMessages = new i18nMessages(i18n.key)

  val i18n = I18n
}
