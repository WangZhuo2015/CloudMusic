package cn.wzhere.cloudmusic.DataModel.PersonalFMModel

//
//	FMModel.java
//	Model file generated using JSONExport: https://github.com/Ahmed-Ali/JSONExport

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName


class FMModel {

    @SerializedName("code")
    var code: Int = 0
    @SerializedName("data")
    var data: Array<FMData>? = null
    @SerializedName("popAdjust")
    var isPopAdjust: Boolean = false

    class Deserializer : ResponseDeserializable<FMModel> {
        override fun deserialize(content: String) = Gson().fromJson(content, FMModel::class.java)
    }
}