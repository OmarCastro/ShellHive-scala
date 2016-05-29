package shared.i18n


/**
  * Created by Omar Castro on 29/05/2016.
  */
class I18n (val key: String)

object I18n {

  class I18nKey(protected val prefix: String){
    def this(i18nKey:I18nKey, postfix: String) = this(i18nKey.prefix+"."+postfix)
    def apply(key: String): I18n = I18n(prefix+"."+key)
  }

  private def apply(key: String): I18n = new I18n(key)

  val angular_component_title_tooltip = I18n("angular.component.title.tooltip")

  object angular extends I18nKey("angular"){

    object component extends I18nKey(angular,"component"){

      object title extends I18nKey(component,"titile"){

        val tooltip = apply("tooltip")
      }
    }
  }
}




