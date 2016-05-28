package com.shellhive.angular.components

import biz.enef.angulate._
import biz.enef.angulate.core.{Attributes, JQLite, Timeout}
import com.shellhive.lib.mousetrap.{Mousetrap, MousetrapEvent}
import org.scalajs.jquery._

import scala.scalajs.js

/**
 * @author Omar Castro <omar-a-castro@telecom.pt>, 08-05-2016.
 */
class MouseTrapDirective($timeout: Timeout) extends Directive {



  // the type of the scope object passed to postLink() and controller()
  override type ScopeType = js.Dynamic

  // the type of the controller instance passed to postLink() and controller()
  override val restrict = "A"

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


    val shortcutSeq : String = attrs("mousetrap").getOrElse("")
    val template : String = shortcutSeq.split('+').map("<kbd>"+_+"</kbd>").mkString("+")
    jqueryElement.append(s"""<div class="small align-right">$template</div>""")

    val bindShortcut = (x: MousetrapEvent) => {
      jqueryElement.trigger("click")
      println("keboard clicked")
      false
    }

    Mousetrap.bind(shortcutSeq,bindShortcut)


  }

  // override def compile(tElement: js.Dynamic, tAttrs: Attributes) : js.Any = ...
}
