package controllers

import play.api.Environment
import play.api.mvc._
import shared.SharedMessages

class Application()(implicit environment: Environment) extends Controller {

  def index = Action {
    Ok(views.html.index(SharedMessages.itWorks))
  }

  def graph = Action {
    Ok(views.html.graph(SharedMessages.itWorks))
  }
}
