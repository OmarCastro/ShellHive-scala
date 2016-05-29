package com.shellhive.angular.components.nodes

import biz.enef.angulate.Directive
import biz.enef.angulate.core.{Attributes, JQLite}
import com.shellhive.components.Icon
import org.scalajs.jquery.{JQuery, JQueryEventObject}
import shared.i18n.I18n

import scala.scalajs.js

/**
  * Created by Omar Castro on 29/05/2016.
  */
class ComponentTitleDirective  extends Directive  {

  override type ScopeType = js.Dynamic

  override val restrict = "A"

  override val scope = true

  override val template = {


    import scalatags.Text.all._

    val tooltip = div(cls := "tooltip", "ng-if".attr := "showTooltip",
      "ng-style".attr := "{transform:'translate(-50%) scale('+(1/transformScale())+')'}")(
      I18n.angular.component.title.tooltip.key
    )

    val titleName = span(cls:="title-name", "ng-bind".attr := "title.name")


    val buttonGroup = span(cls:="button-group", "ng-if".attr := "title.buttons")(
      a("ng-click".attr := "togglecollapse()", "ng-class".attr := s"(collapsed)?'${Icon.chevronUp}':'${Icon.chevronDown}'"),
      " ",
      a("ng-click".attr := "$emit('removeComponent', data.id)", cls := s"close-button ${Icon.remove}")
    )

    tooltip.render + titleName.render + buttonGroup.render



  }

  override def postLink(scope: ScopeType,
                        element: JQLite,
                        attrs: Attributes,
                        controller: ControllerType) = {



  }
}
