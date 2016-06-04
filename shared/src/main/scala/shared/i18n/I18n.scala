package shared.i18n


/**
  * Provides type-safe access to i18n keys on both the server and client
  */
object I18n {
  object angular extends I18nKey{
    object component extends I18nKey(angular){
      object title extends I18nKey(component){
        def tooltip = apply("tooltip")
      }
    }
  }
}

class I18n (val key: String)

class I18nKey{
  private var prefix: String = this.getClass.getName.split("\\$").last
  def this(i18nKey:I18nKey) = {this(); this.prefix =s"${i18nKey.prefix}.$prefix"}
  def apply(key: => String): I18n = new I18n(s"$prefix.$key")
}




