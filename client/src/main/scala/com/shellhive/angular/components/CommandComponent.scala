package com.shellhive.angular.components

import biz.enef.angulate._
import scalajs.js
/**
 * @author Omar Castro <omar-a-castro@telecom.pt>, 08-05-2016.
 */
@Component(ComponentDef(
  selector = "component",
  template = """
<div class="component" data-command-name="cat">
  <div class="tip title">
    <div class="tooltip" ng-if="showTooltip" ng-style="{transform:'translate(-50%) scale('+(1/transformScale())+')'}"> Drag me to move me! </div>
    <span class="title-name" ng-bind="title.name"></span>
    <span class="button-group" ng-if="title.buttons">
      <a ng-click="togglecollapse()"
         class="glyphicon"
         ng-class="(collapsed)?'glyphicon-chevron-up':'glyphicon-chevron-down'">
      </a>
      <a ng-click="$emit('removeComponent', data.id)" class="close-button glyphicon glyphicon-remove"></a>
  </div>
</div>"""
))
class CommandComponent {


  var showTooltip = false

  var title = js.Dictionary(
    "name" -> "cat",
    "buttons" -> true
  )

  var status = js.Dictionary(
    "noTooltip" -> false
  )

  def transformScale() = 1

  var command = "cat"

}




