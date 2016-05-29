import controllers.{Application, Assets}
import jsmessages.JsMessagesFactoryComponents
import play.api.ApplicationLoader.Context
import play.api.i18n.I18nComponents
import play.api.{ApplicationLoader, BuiltInComponentsFromContext}
import router.Routes

class ShellHiveApplicationLoader() extends ApplicationLoader {
  def load(context: Context) = new ApplicationComponents(context).application
}

class ApplicationComponents(context: Context) extends BuiltInComponentsFromContext(context) with I18nComponents with JsMessagesFactoryComponents {
  lazy val applicationController = new Application()(environment, jsMessagesFactory, messagesApi)
  lazy val assets = new Assets(httpErrorHandler)
  override lazy val router = new Routes(httpErrorHandler, applicationController, assets)
}