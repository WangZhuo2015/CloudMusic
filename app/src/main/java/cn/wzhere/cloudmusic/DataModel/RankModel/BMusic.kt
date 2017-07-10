package cn.wzhere.cloudmusic.DataModel.RankModel

//
//	BMusic.java
//	Model file generated using JSONExport: https://github.com/Ahmed-Ali/JSONExport

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
import org.json.*
import java.util.*
import com.google.gson.annotations.SerializedName


class BMusic {

    @SerializedName("bitrate")
    var bitrate: String? =""
    @SerializedName("dfsId")
    var dfsId: String? =""
    @SerializedName("dfsId_str")
    var dfsIdStr: Any? = null
    @SerializedName("extension")
    var extension: String? = null
    @SerializedName("id")
    var id: String? =""
    @SerializedName("name")
    var name: Any? = null
    @SerializedName("playTime")
    var playTime: String? =""
    @SerializedName("size")
    var size: String? =""
    @SerializedName("sr")
    var sr: String? =""
    @SerializedName("volumeDelta")
    var volumeDelta: Float = 0.toFloat()

    class Deserializer : ResponseDeserializable<BMusic> {
        override fun deserialize(content: String) = Gson().fromJson(content, BMusic::class.java)
    }
}