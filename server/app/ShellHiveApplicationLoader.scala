import controllers.{WebSocketCtrl, Application, Assets}
import jsmessages.JsMessagesFactoryComponents
import play.api.ApplicationLoader.Context
import play.api.i18n.I18nComponents
import play.api.{ApplicationLoader, BuiltInComponentsFromContext}
import utils.i18n.i18nMessages
import router.Routes

class ShellHiveApplicationLoader() extends ApplicationLoader {
  def load(context: Context) = new ApplicationComponents(context).application
}

class ApplicationComponents(context: Context) extends BuiltInComponentsFromContext(context) with I18nComponents with JsMessagesFactoryComponents{
  i18nMessages.messageApi = messagesApi;
  lazy val applicationController = new Application()(environment, jsMessagesFactory, messagesApi)
  lazy val webSocketCtrl = new WebSocketCtrl()(actorSystem, materializer)
  lazy val assets = new Assets(httpErrorHandler)
  override lazy val router = new Routes(httpErrorHandler, applicationController, assets, webSocketCtrl)
}