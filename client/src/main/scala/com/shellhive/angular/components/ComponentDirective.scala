package com.shellhive.angular.components

import biz.enef.angulate._
import biz.enef.angulate.core.{Attributes, JQLite, Timeout}
import org.scalajs.dom
import org.scalajs.dom.raw.MouseEvent
import org.scalajs.jquery._

import scala.scalajs.js

/**
 * @author Omar Castro <omar-a-castro@telecom.pt>, 08-05-2016.
 */
class ComponentDirective($timeout: Timeout) extends Directive {



  // the type of the scope object passed to postLink() and controller()
  override type ScopeType = js.Dynamic

  // the type of the controller instance passed to postLink() and controller()
  override val restrict = "E"

  override val scope = true


  override val template =
    """
      |  <div class="tip title" touch-action="none">
      |    <div class="tooltip" ng-if="showTooltip" ng-style="{transform:'translate(-50%) scale('+(1/transformScale())+')'}"> Drag me to move me! </div>
      |    <span class="title-name" ng-bind="title.name"></span>
      |    <span class="button-group" ng-if="title.buttons">
      |      <a ng-click="togglecollapse()" class="glyphicon"
      |         ng-class="(collapsed)?'glyphicon-chevron-up':'glyphicon-chevron-down'">
      |      </a>
      |      <a ng-click="$emit('removeComponent', data.id)" class="close-button glyphicon glyphicon-remove"></a>
      |  </div>
      |  <div ng-transclude></div>
    """.stripMargin

  override def transclude = true

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
    jqueryElement.addClass("component")


    var translateX:Double = 0
    var translateY:Double = 0

    def updateTransform() = {
      jqueryElement.attr("style", s"transform: translate(${translateX}px,${translateY}px)")
    }

    updateTransform()


    scope.showTooltip = false

    scope.commandName = attrs("command")

    scope.title = js.Dictionary(
      "name" -> attrs("command"),
      "buttons" -> true
    )

    scope.status = js.Dictionary(
      "noTooltip" -> false
    )

    var initX: Double = 0
    var initY: Double = 0
    var initTrX: Double = 0
    var initTrY: Double = 0

    jqueryElement.on("pointerdown", (e : MouseEvent) => {
      initX = e.screenX
      initY = e.screenY
      initTrX = translateX
      initTrY = translateY

      if(jQuery(e.target).parents(".tip").length > 0){
        jQuery(dom.document.body).attr("touch-action","none")
        jQuery(dom.document.body).on("pointermove", (e: MouseEvent) => {
          println(s"mimi, $translateX, $translateY")
          translateX = initTrX - initX + e.screenX
          translateY = initTrY - initY + e.screenY
          updateTransform()
          e.preventDefault()
          false
        })

        jQuery(dom.document.body).on("pointerup", (e: MouseEvent) => {
          jQuery(dom.document.body).off("pointermove")
          jQuery(dom.document.body).off("pointerup")
          jQuery(dom.document.body).attr("touch-action",null)

        })

        e.preventDefault()
        false
      }

    })

  }

  // override def compile(tElement: js.Dynamic, tAttrs: Attributes) : js.Any = ...
}

