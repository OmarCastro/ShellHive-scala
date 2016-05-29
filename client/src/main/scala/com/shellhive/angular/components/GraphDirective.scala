package com.shellhive.angular.components

import biz.enef.angulate._
import biz.enef.angulate.core.{Attributes, JQLite, Timeout}
import org.scalajs.jquery._

import scala.scalajs.js

/**
  * @author Omar Castro <omar.castro.360@gmail.com>, 08-05-2016.
 */
class GraphDirective($timeout: Timeout) extends Directive {



  // the type of the scope object passed to postLink() and controller()
  override type ScopeType = js.Dynamic

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

    scope.invertHelp = () => {
      scope.showTooltip = !scope.showTooltip
      scope.status.noTooltip = !scope.showTooltip
      println("invertHelp")
    }

    scope.status = js.Dictionary(
      "noTooltip" -> false
    )

  }

  // override def compile(tElement: js.Dynamic, tAttrs: Attributes) : js.Any = ...
}
