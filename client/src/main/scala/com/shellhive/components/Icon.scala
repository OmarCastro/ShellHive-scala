package com.shellhive.components

/**
  * Provides type-safe access to Font Awesome icons
  */
object Icon {


  def apply(name: String): String = s"glyphicon glyphicon-$name"

  def asterisk  = apply("asterisk")
  def plus  = apply("plus")
  def euro  = apply("euro")
  def minus  = apply("minus")
  def cloud  = apply("cloud")
  def envelope  = apply("envelope")
  def pencil  = apply("pencil")
  def glass  = apply("glass")
  def music  = apply("music")
  def search  = apply("search")
  def heart  = apply("heart")
  def star  = apply("star")
  def starEmpty  = apply("star-empty")
  def user  = apply("user")
  def film  = apply("film")
  def thLarge  = apply("th-large")
  def th  = apply("th")
  def thList  = apply("th-list")
  def ok  = apply("ok")
  def remove  = apply("remove")
  def zoomIn  = apply("zoom-in")
  def zoomOut  = apply("zoom-out")
  def off  = apply("off")
  def signal  = apply("signal")
  def cog  = apply("cog")
  def trash  = apply("trash")
  def home  = apply("home")
  def file  = apply("file")
  def time  = apply("time")
  def road  = apply("road")
  def downloadAlt  = apply("download-alt")
  def download  = apply("download")
  def upload  = apply("upload")
  def inbox  = apply("inbox")
  def playCircle  = apply("play-circle")
  def repeat  = apply("repeat")
  def refresh  = apply("refresh")
  def listAlt  = apply("list-alt")
  def lock  = apply("lock")
  def flag  = apply("flag")
  def headphones  = apply("headphones")
  def volumeOff  = apply("volume-off")
  def volumeDown  = apply("volume-down")
  def volumeUp  = apply("volume-up")
  def qrcode  = apply("qrcode")
  def barcode  = apply("barcode")
  def tag  = apply("tag")
  def tags  = apply("tags")
  def book  = apply("book")
  def bookmark  = apply("bookmark")
  def print  = apply("print")
  def camera  = apply("camera")
  def font  = apply("font")
  def bold  = apply("bold")
  def italic  = apply("italic")
  def textHeight  = apply("text-height")
  def textWidth  = apply("text-width")
  def alignLeft  = apply("align-left")
  def alignCenter  = apply("align-center")
  def alignRight  = apply("align-right")
  def alignJustify  = apply("align-justify")
  def list  = apply("list")
  def indentLeft  = apply("indent-left")
  def indentRight  = apply("indent-right")
  def facetimeVideo  = apply("facetime-video")
  def picture  = apply("picture")
  def mapMarker  = apply("map-marker")
  def adjust  = apply("adjust")
  def tint  = apply("tint")
  def edit  = apply("edit")
  def share  = apply("share")
  def check  = apply("check")
  def move  = apply("move")
  def stepBackward  = apply("step-backward")
  def fastBackward  = apply("fast-backward")
  def backward  = apply("backward")
  def play  = apply("play")
  def pause  = apply("pause")
  def stop  = apply("stop")
  def forward  = apply("forward")
  def fastForward  = apply("fast-forward")
  def stepForward  = apply("step-forward")
  def eject  = apply("eject")
  def chevronLeft  = apply("chevron-left")
  def chevronRight  = apply("chevron-right")
  def plusSign  = apply("plus-sign")
  def minusSign  = apply("minus-sign")
  def removeSign()  = apply("remove-sign")
  def okSign  = apply("ok-sign")
  def questionSign  = apply("question-sign")
  def infoSign  = apply("info-sign")
  def screenshot  = apply("screenshot")
  def removeCircle()  = apply("remove-circle")
  def okCircle  = apply("ok-circle")
  def banCircle  = apply("ban-circle")
  def arrowLeft  = apply("arrow-left")
  def arrowRight  = apply("arrow-right")
  def arrowUp  = apply("arrow-up")
  def arrowDown  = apply("arrow-down")
  def shareAlt  = apply("share-alt")
  def resizeFull  = apply("resize-full")
  def resizeSmall  = apply("resize-small")
  def exclamationSign  = apply("exclamation-sign")
  def gift  = apply("gift")
  def leaf  = apply("leaf")
  def fire  = apply("fire")
  def eyeOpen  = apply("eye-open")
  def eyeClose  = apply("eye-close")
  def warningSign  = apply("warning-sign")
  def plane  = apply("plane")
  def calendar  = apply("calendar")
  def random  = apply("random")
  def comment  = apply("comment")
  def magnet  = apply("magnet")
  def chevronUp  = apply("chevron-up")
  def chevronDown  = apply("chevron-down")
  def retweet  = apply("retweet")
  def shoppingCart  = apply("shopping-cart")
  def folderClose  = apply("folder-close")
  def folderOpen  = apply("folder-open")
  def resizeVertical  = apply("resize-vertical")
  def resizeHorizontal  = apply("resize-horizontal")
  def hdd  = apply("hdd")
  def bullhorn  = apply("bullhorn")
  def bell  = apply("bell")
  def certificate  = apply("certificate")
  def thumbsUp  = apply("thumbs-up")
  def thumbsDown  = apply("thumbs-down")
  def handRight  = apply("hand-right")
  def handLeft  = apply("hand-left")
  def handUp  = apply("hand-up")
  def handDown  = apply("hand-down")
  def circle_arrow_right  = apply("circle-arrow-right")
  def circle_arrow_left  = apply("circle-arrow-left")
  def circle_arrow_up  = apply("circle-arrow-up")
  def circle_arrow_down  = apply("circle-arrow-down")
  def globe  = apply("globe")
  def wrench  = apply("wrench")
  def tasks  = apply("tasks")
  def filter  = apply("filter")
  def briefcase  = apply("briefcase")
  def fullscreen  = apply("fullscreen")
  def dashboard  = apply("dashboard")
  def paperclip  = apply("paperclip")
  def heart_empty  = apply("heart-empty")
  def link  = apply("link")
  def phone  = apply("phone")
  def pushpin  = apply("pushpin")
  def usd  = apply("usd")
  def gbp  = apply("gbp")
  def sort  = apply("sort")
  def sortBy_alphabet  = apply("sort-by-alphabet")
  def sortBy_alphabet_alt  = apply("sort-by-alphabet-alt")
  def sortBy_order  = apply("sort-by-order")
  def sortBy_order_alt  = apply("sort-by-order-alt")
  def sortBy_attributes  = apply("sort-by-attributes")
  def sortBy_attributes_alt  = apply("sort-by-attributes-alt")
  def unchecked  = apply("unchecked")
  def expand  = apply("expand")
  def collapse_down  = apply("collapse-down")
  def collapse_up  = apply("collapse-up")
  def logIn  = apply("log-in")
  def flash  = apply("flash")
  def logOut  = apply("log-out")
  def newWindow  = apply("new-window")
  def record  = apply("record")
  def save  = apply("save")
  def open  = apply("open")
  def saved  = apply("saved")
  def importIcon  = apply("import")
  def export  = apply("export")
  def send  = apply("send")
  def floppy_disk  = apply("floppy-disk")
  def floppy_saved  = apply("floppy-saved")
  def floppy_remove  = apply("floppy-remove")
  def floppy_save  = apply("floppy-save")
  def floppy_open  = apply("floppy-open")
  def credit_card  = apply("credit-card")
  def transfer  = apply("transfer")
  def cutlery  = apply("cutlery")
  def header  = apply("header")
  def compressed  = apply("compressed")
  def earphone  = apply("earphone")
  def phone_alt  = apply("phone-alt")
  def tower  = apply("tower")
  def stats  = apply("stats")
  def SD_video  = apply("sd-video")
  def HD_video  = apply("hd-video")
  def subtitles  = apply("subtitles")
  def soundStereo  = apply("sound-stereo")
  def soundDolby  = apply("sound-dolby")
  def sound_5_1  = apply("sound-5-1")
  def sound_6_1  = apply("sound-6-1")
  def sound_7_1  = apply("sound-7-1")
  def copyrightMark  = apply("copyright-mark")
  def registrationMark  = apply("registration-mark")
  def cloudDownload  = apply("cloud-download")
  def cloudUpload  = apply("cloud-upload")
  def treeConifer  = apply("tree-conifer")
  def treeDeciduous  = apply("tree-deciduous")
}