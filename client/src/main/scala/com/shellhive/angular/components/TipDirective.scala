package com.shellhive.angular.components
import biz.enef.angulate._

import biz.enef.angulate.core.Attributes
import biz.enef.angulate.core.Timeout
import biz.enef.angulate.core.JQLite
import scalajs.js
import org.scalajs.jquery._

/**
  * @author Omar Castro <omar.castro.360@gmail.com>, 29-05-2016.
 */
class TipDirective($timeout: Timeout) extends Directive {



  // the type of the scope object passed to postLink() and controller()
  override type ScopeType = js.Dynamic

  // the type of the controller instance passed to postLink() and controller()
  override val restrict = "C"

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

    val jqueryElement = element.asInstanceOf[JQuery]


    val hoverIn = (x: JQueryEventObject) => {
        if(!js.isUndefined(scope.status) && !scope.status.noTooltip.asInstanceOf[Boolean]){
          scope.showTooltip = true; scope.$digest()
        }
        null
      }

    val hoverOut = (x: JQueryEventObject) => {
      if(js.typeOf(scope.showTooltip) == "boolean"  && scope.showTooltip.asInstanceOf[Boolean]){
        scope.showTooltip = false; scope.$digest()
      }
      null
    }

    jqueryElement.hover(hoverIn,hoverOut)



  }

  // override def compile(tElement: js.Dynamic, tAttrs: Attributes) : js.Any = ...
}
