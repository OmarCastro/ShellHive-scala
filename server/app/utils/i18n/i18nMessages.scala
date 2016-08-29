package utils.i18n

import java.util.Locale

import play.api.i18n.{Lang, MessagesApi, Messages}



object i18nMessages {
  var messageApi:  MessagesApi = null

  def getLang(): Lang = {
    var lang: Lang = null
    if (play.mvc.Http.Context.current.get != null) {
      lang = play.mvc.Http.Context.current.get().lang()
    }
    else {
      lang = new Lang (Locale.getDefault)
    }
    return lang
  }

  private def getMessages(lang: Lang): Messages = {
    return messageApi.preferred(Seq(lang))
  }
}

class i18nMessages(val key: String){
  import i18nMessages._

  def translate(): String = getMessages(getLang())(key)
}

