package cn.wzhere.cloudmusic.DataModel.RankModel

//
//	RankModel.java
//	Model file generated using JSONExport: https://github.com/Ahmed-Ali/JSONExport

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName


class RankModel {

    @SerializedName("code")
    var code: Int = 0
    @SerializedName("result")
    var result: RankResult? = null

    class Deserializer : ResponseDeserializable<RankModel> {
        override fun deserialize(content: String) = Gson().fromJson(content, RankModel::class.java)
    }
}