package cn.wzhere.cloudmusic.DataModel.SongModel

//
//	SongData.java
//	Model file generated using JSONExport: https://github.com/Ahmed-Ali/JSONExport

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName


class SongData {

    @SerializedName("br")
    var br: Int = 0
    @SerializedName("canExtend")
    var isCanExtend: Boolean = false
    @SerializedName("code")
    var code: Int = 0
    @SerializedName("expi")
    var expi: Int = 0
    @SerializedName("fee")
    var fee: Int = 0
    @SerializedName("flag")
    var flag: Int = 0
    @SerializedName("gain")
    var gain: Double = 0.toDouble()
    @SerializedName("id")
    var id: Int = 0
    @SerializedName("md5")
    var md5: String? = null
    @SerializedName("payed")
    var payed: Int = 0
    @SerializedName("size")
    var size: Int = 0
    @SerializedName("type")
    var type: String? = null
    @SerializedName("uf")
    var uf: Any? = null
    @SerializedName("url")
    var url: String? = null

    class Deserializer : ResponseDeserializable<SongData> {
        override fun deserialize(content: String) = Gson().fromJson(content, SongData::class.java)
    }
}