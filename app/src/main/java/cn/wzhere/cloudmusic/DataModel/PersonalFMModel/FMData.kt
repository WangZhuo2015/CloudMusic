package cn.wzhere.cloudmusic.DataModel.PersonalFMModel

//
//	Data.java
//	Model file generated using JSONExport: https://github.com/Ahmed-Ali/JSONExport

import org.json.*
import java.util.*
import com.google.gson.annotations.SerializedName

import cn.wzhere.cloudmusic.DataModel.RankModel.Album
import cn.wzhere.cloudmusic.DataModel.RankModel.Artist
import cn.wzhere.cloudmusic.DataModel.RankModel.BMusic
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson


class Data {

    @SerializedName("album")
    var album: Album? = null
    @SerializedName("alg")
    var alg: String? = null
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
    @SerializedName("copyrightId")
    var copyrightId: Int = 0
    @SerializedName("crbt")
    var crbt: Any? = null
    @SerializedName("dayPlays")
    var dayPlays: Int = 0
    @SerializedName("disc")
    var disc: String? = null
    @SerializedName("duration")
    var duration: Int = 0
    @SerializedName("fee")
    var fee: Int = 0
    @SerializedName("ftype")
    var ftype: Int = 0
    @SerializedName("hMusic")
    var hMusic: BMusic? = null
    @SerializedName("hearTime")
    var hearTime: Int = 0
    @SerializedName("id")
    var id: Int = 0
    @SerializedName("lMusic")
    var lMusic: BMusic? = null
    @SerializedName("mMusic")
    var mMusic: BMusic? = null
    @SerializedName("mp3Url")
    var mp3Url: String? = null
    @SerializedName("mvid")
    var mvid: Int = 0
    @SerializedName("name")
    var name: String? = null
    @SerializedName("no")
    var no: Int = 0
    @SerializedName("playedNum")
    var playedNum: Int = 0
    @SerializedName("popularity")
    var popularity: Float = 0.toFloat()
    @SerializedName("privilege")
    var privilege: Privilege? = null
    @SerializedName("ringtone")
    var ringtone: Any? = null
    @SerializedName("rtUrl")
    var rtUrl: Any? = null
    @SerializedName("rtUrls")
    var rtUrls: Any? = null
    @SerializedName("rtype")
    var rtype: Int = 0
    @SerializedName("rurl")
    var rurl: Any? = null
    @SerializedName("score")
    var score: Int = 0
    @SerializedName("starred")
    var isStarred: Boolean = false
    @SerializedName("starredNum")
    var starredNum: Int = 0
    @SerializedName("status")
    var status: Int = 0
    class Deserializer : ResponseDeserializable<Data> {
        override fun deserialize(content: String) = Gson().fromJson(content, Data::class.java)
    }
}