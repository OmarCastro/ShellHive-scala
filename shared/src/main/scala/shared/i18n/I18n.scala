package shared.i18n


/**
  * Provides type-safe access to i18n keys on both the server and client
  */
object I18n {
  object help{
    object componentMove extends I18nKeys{
      val tooltip = key("tooltip")
    }

    object navMenu extends I18nKeys{
      val command = key("command")
      val macros = key("macros")
      val view = key("view")
      val actions = key("actions")
    }
  }
}

sealed case class I18n(key : String)

sealed class I18nKeys{
  val nodeKey: String = this.getClass.getName.split("\\$").drop(1).mkString(".")
  def key(key:String): I18n = new I18n(s"$nodeKey.$key")
}




