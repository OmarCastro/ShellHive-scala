package controllers

import play.api.Environment
import play.api.mvc._
import shared.SharedMessages
import jsmessages.JsMessagesFactory
import play.api.i18n.{I18nSupport, MessagesApi}

class Application()(implicit environment: Environment, jsMessagesFactory: JsMessagesFactory, val messagesApi: MessagesApi ) extends Controller with I18nSupport  {

  def index = Action {
    Ok(views.html.index(SharedMessages.itWorks))
  }

  def graph = Action {
    Ok(views.html.graph(SharedMessages.itWorks))
  }

  def jsMessages = Action { implicit request =>
    Ok(jsMessagesFactory.all.all(Some("window.Messages")))
  }
}
