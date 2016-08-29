package com.shellhive.angular.components

import biz.enef.angulate._
import biz.enef.angulate.core.{Attributes, JQLite, Timeout}
import org.scalajs.jquery._

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExport

object GraphDirective {
  trait DirectiveScope extends Scope {
    var showTooltip: Boolean
    @JSExport
    var invertHelp: js.Function
    var status: js.Dictionary[js.Any]
  }
}


/**
  * @author Omar Castro <omar.castro.360@gmail.com>, 08-05-2016.
 */
class GraphDirective($timeout: Timeout) extends Directive {
  // the type of the scope object passed to postLink() and controller()
  override type ScopeType = GraphDirective.DirectiveScope

  // the type of the controller instance passed to postLink() and controller()
  override val restrict = "E"

  override val scope = true
  // -- or --
  // override def template(element,attrs) = ...
  // -- or --
  // override val templateUrl = "/url"
  // -- or --
  // override def templateUrl(element,attrs) = ...

  // -- or --
  // override val scope = true

  override def postLink(scope: ScopeType,
                        element: JQLite,
                        attrs: Attributes,
                        controller: ControllerType) = {

    element.addClass("graph workspace")

    scope.showTooltip = true

    scope.status = js.Dictionary(
      "noTooltip" -> false
    )


    scope.invertHelp = () => {
      scope.showTooltip = !scope.showTooltip
      scope.status.update("noTooltip",!scope.showTooltip)
      element.toggleClass("help-off", !scope.showTooltip)
      println("invertHelp")
    }


  }

  // override def compile(tElement: js.Dynamic, tAttrs: Attributes) : js.Any = ...
}
