package cn.wzhere.cloudmusic.DataModel.PersonalFMModel

//
//	FMData.java
//	Model file generated using JSONExport: https://github.com/Ahmed-Ali/JSONExport

import com.google.gson.annotations.SerializedName

import cn.wzhere.cloudmusic.DataModel.RankModel.Album
import cn.wzhere.cloudmusic.DataModel.RankModel.Artist
import cn.wzhere.cloudmusic.DataModel.RankModel.BMusic
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson


class FMData {

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
    var copyrightId: String = ""
    @SerializedName("crbt")
    var crbt: Any? = null
    @SerializedName("dayPlays")
    var dayPlays: String = ""
    @SerializedName("disc")
    var disc: String? = null
    @SerializedName("duration")
    var duration: String = ""
    @SerializedName("fee")
    var fee: String = ""
    @SerializedName("ftype")
    var ftype: String = ""
    @SerializedName("hMusic")
    var hMusic: BMusic? = null
    @SerializedName("hearTime")
    var hearTime: String = ""
    @SerializedName("id")
    var id: String = ""
    @SerializedName("lMusic")
    var lMusic: BMusic? = null
    @SerializedName("mMusic")
    var mMusic: BMusic? = null
    @SerializedName("mp3Url")
    var mp3Url: String? = null
    @SerializedName("mvid")
    var mvid: String = ""
    @SerializedName("name")
    var name: String? = null
    @SerializedName("no")
    var no: String = ""
    @SerializedName("playedNum")
    var playedNum: String = ""
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
    var rtype: String = ""
    @SerializedName("rurl")
    var rurl: Any? = null
    @SerializedName("score")
    var score: String = ""
    @SerializedName("starred")
    var isStarred: Boolean = false
    @SerializedName("starredNum")
    var starredNum: String = ""
    @SerializedName("status")
    var status: String = ""
    class Deserializer : ResponseDeserializable<FMData> {
        override fun deserialize(content: String) = Gson().fromJson(content, FMData::class.java)
    }
}