package cn.wzhere.cloudmusic.DataModel.SongModel

//
//	SongModel.java
//	Model file generated using JSONExport: https://github.com/Ahmed-Ali/JSONExport

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName


class SongModel {

    @SerializedName("code")
    var code: Int = 0
    @SerializedName("data")
    var data: Array<SongData>? = null
    class Deserializer : ResponseDeserializable<SongModel> {
        override fun deserialize(content: String) = Gson().fromJson(content, SongModel::class.java)
    }
}