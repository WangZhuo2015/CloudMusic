package cn.wzhere.cloudmusic.DataModel.PersonalFMModel

//
//	FMModel.java
//	Model file generated using JSONExport: https://github.com/Ahmed-Ali/JSONExport

import org.json.*
import java.util.*
import cn.wzhere.cloudmusic.DataModel.PersonalFMModel.Data
import cn.wzhere.cloudmusic.DataModel.RankModel.Album
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName


class FMModel {

    @SerializedName("code")
    var code: Int = 0
    @SerializedName("data")
    var data: Array<Data>? = null
    @SerializedName("popAdjust")
    var isPopAdjust: Boolean = false

    class Deserializer : ResponseDeserializable<FMModel> {
        override fun deserialize(content: String) = Gson().fromJson(content, FMModel::class.java)
    }
}