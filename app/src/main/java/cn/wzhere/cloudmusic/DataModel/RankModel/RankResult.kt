package cn.wzhere.cloudmusic.DataModel.RankModel

//
//	RankResult.java
//	Model file generated using JSONExport: https://github.com/Ahmed-Ali/JSONExport

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
import org.json.*
import java.util.*
import com.google.gson.annotations.SerializedName
import java.io.Serializable


class RankResult : Serializable {

    @SerializedName("adType")
    var adType: String? = ""
    @SerializedName("anonimous")
    var isAnonimous: Boolean = false
    @SerializedName("artists")
    var artists: Any? = null
    @SerializedName("cloudTrackCount")
    var cloudTrackCount: String? = ""
    @SerializedName("commentCount")
    var commentCount: String? = ""
    @SerializedName("commentThreadId")
    var commentThreadId: String? = null
    @SerializedName("coverImgId")
    var coverImgId: String? = ""
    @SerializedName("coverImgId_str")
    var coverImgIdStr: String? = null
    @SerializedName("coverImgUrl")
    var coverImgUrl: String? = null
    @SerializedName("createTime")
    var createTime: String? = ""
    @SerializedName("creator")
    var creator: Creator? = null
    @SerializedName("description")
    var description: String? = null
    @SerializedName("highQuality")
    var isHighQuality: Boolean = false
    @SerializedName("id")
    var id: String? = ""
    @SerializedName("name")
    var name: String? = null
    @SerializedName("newImported")
    var isNewImported: Boolean = false
    @SerializedName("ordered")
    var isOrdered: Boolean = false
    @SerializedName("playCount")
    var playCount: String? = ""
    @SerializedName("privacy")
    var privacy: String? = ""
    @SerializedName("shareCount")
    var shareCount: String? = ""
    @SerializedName("specialType")
    var specialType: String? = ""
    @SerializedName("status")
    var status: String? = ""
    @SerializedName("subscribed")
    var isSubscribed: Boolean = false
    @SerializedName("subscribedCount")
    var subscribedCount: String? = ""
    @SerializedName("subscribers")
    var subscribers: Array<Any>? = null
    @SerializedName("tags")
    var tags: Array<String>? = null
    @SerializedName("totalDuration")
    var totalDuration: String? = ""
    @SerializedName("trackCount")
    var trackCount: String? = ""
    @SerializedName("trackNumberUpdateTime")
    var trackNumberUpdateTime: String? = ""
    @SerializedName("trackUpdateTime")
    var trackUpdateTime: String? = ""
    @SerializedName("tracks")
    var tracks: Array<Track>? = null
    @SerializedName("updateTime")
    var updateTime: String? = ""
    @SerializedName("userId")
    var userId: String? = ""

    class Deserializer : ResponseDeserializable<RankResult> {
        override fun deserialize(content: String) = Gson().fromJson(content, RankResult::class.java)
    }
}