package com.shellhive.angular.components.nodes

import biz.enef.angulate._
import biz.enef.angulate.core.{Attributes, JQLite, Timeout}
import com.shellhive.components.Icon
import org.scalajs.dom
import org.scalajs.dom.raw.MouseEvent
import org.scalajs.jquery._
import shared.i18n.I18n

import scala.scalajs.js

/**
 * @author Omar Castro <omar.castro.360@gmail.com>, 08-05-2016.
  *
  * Component Directive
  *
  * a visual representation of the calling command
  *
  * Usage:
  *   <component data-command="command name"><component>
  *
 */
class ComponentDirective($timeout: Timeout) extends Directive {



  // the type of the scope object passed to postLink() and controller()
  override type ScopeType = js.Dynamic

  // the type of the controller instance passed to postLink() and controller()
  override val restrict = "E"

  override val scope = true


  override val template = """
      |<div class="tip title" data-component-title touch-action="none"></div>
      |<div data-ng-transclude>
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


    var translateX:Double = attrs("posX").getOrElse("0").toDouble
    var translateY:Double = attrs("posY").getOrElse("0").toDouble

    def updateTransform() = {
      jqueryElement.attr("style", s"transform: translate(${translateX}px,${translateY}px)")
    }

    updateTransform()



    scope.commandName = attrs("command")

    scope.title = js.Dictionary(
      "name" -> attrs("command"),
      "buttons" -> true
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
          translateX = initTrX - initX + e.screenX
          translateY = initTrY - initY + e.screenY
          updateTransform()
          e.preventDefault()
          false
        })

        jQuery(dom.document.body).on("pointerup", (e: MouseEvent) => {
          jQuery(dom.document.body).off("pointermove").off("pointerup")
          jQuery(dom.document.body).attr("touch-action",null)

        })

        e.preventDefault()
        false
      }

    })

  }

  // override def compile(tElement: js.Dynamic, tAttrs: Attributes) : js.Any = ...
}

