package cn.wzhere.cloudmusic.DataModel.RankModel

//
//	Track.java
//	Model file generated using JSONExport: https://github.com/Ahmed-Ali/JSONExport

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
import org.json.*
import java.util.*
import com.google.gson.annotations.SerializedName
import java.io.Serializable


class Track :Serializable{

    @SerializedName("album")
    var album: Album? = null
    @SerializedName("alias")
    var alias: Array<Any>? = null
    @SerializedName("artists")
    var artists: Array<Artist>? = null
    @SerializedName("audition")
    var audition: Any? = null
    @SerializedName("bMusic")
    var bMusic: BMusic? = null
    @SerializedName("commentThreadId")
    var commentThreadId: String? = null
    @SerializedName("copyFrom")
    var copyFrom: String? = null
    @SerializedName("copyright")
    var copyright: String? = ""
    @SerializedName("copyrightId")
    var copyrightId: String? = ""
    @SerializedName("crbt")
    var crbt: Any? = null
    @SerializedName("dayPlays")
    var dayPlays: String? = ""
    @SerializedName("disc")
    var disc: String? = null
    @SerializedName("duration")
    var duration: String? = ""
    @SerializedName("fee")
    var fee: String? = ""
    @SerializedName("ftype")
    var ftype: String? = ""
    @SerializedName("hMusic")
    var hMusic: BMusic? = null
    @SerializedName("hearTime")
    var hearTime: String? = ""
    @SerializedName("id")
    var id: String? = ""
    @SerializedName("lMusic")
    var lMusic: BMusic? = null
    @SerializedName("lastRank")
    var lastRank: String? = ""
    @SerializedName("mMusic")
    var mMusic: BMusic? = null
    @SerializedName("mp3Url")
    var mp3Url: Any? = null
    @SerializedName("mvid")
    var mvid: String? = ""
    @SerializedName("name")
    var name: String? = null
    @SerializedName("no")
    var no: String? = ""
    @SerializedName("playedNum")
    var playedNum: String? = ""
    @SerializedName("popularity")
    var popularity: Float = 0.toFloat()
    @SerializedName("position")
    var position: String? = ""
    @SerializedName("ringtone")
    var ringtone: Any? = null
    @SerializedName("rtUrl")
    var rtUrl: Any? = null
    @SerializedName("rtUrls")
    var rtUrls: Array<Any>? = null
    @SerializedName("rtype")
    var rtype: String? = ""
    @SerializedName("rurl")
    var rurl: Any? = null
    @SerializedName("score")
    var score: String? = ""
    @SerializedName("starred")
    var isStarred: Boolean = false
    @SerializedName("starredNum")
    var starredNum: String? = ""
    @SerializedName("status")
    var status: String? = ""

    class Deserializer : ResponseDeserializable<Track> {
        override fun deserialize(content: String) = Gson().fromJson(content, Track::class.java)
    }
}