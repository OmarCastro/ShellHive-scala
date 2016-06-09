package controllers

import play.api.Environment
import play.api.mvc._
import play.api.routing.JavaScriptReverseRouter
import shared.SharedMessages
import jsmessages.JsMessagesFactory
import play.api.i18n.{I18nSupport, MessagesApi}
import utils.i18n.i18nMessages

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

  def getLang = Action { implicit request =>
    Ok(i18nMessages.getLang().country)
  }

  def javascriptRoutes = Action { implicit request =>
    Ok(
      JavaScriptReverseRouter("jsRoutes")(
        routes.javascript.Application.graph,
        routes.javascript.Application.index,
        routes.javascript.WebSocketCtrl.socket
      )
    ).as("text/javascript")
  }
}
