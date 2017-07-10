package cn.wzhere.cloudmusic.DataModel.RankModel

//
//	Artist.java
//	Model file generated using JSONExport: https://github.com/Ahmed-Ali/JSONExport

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
import org.json.*
import java.util.*
import com.google.gson.annotations.SerializedName
import java.io.Serializable


class Artist : Serializable {

    @SerializedName("albumSize")
    var albumSize: String? = ""
    @SerializedName("alias")
    var alias: Array<Any>? = null
    @SerializedName("briefDesc")
    var briefDesc: String? = null
    @SerializedName("id")
    var id: String? = ""
    @SerializedName("img1v1Id")
    var img1v1Id: String? = ""
    @SerializedName("img1v1Url")
    var img1v1Url: String? = null
    @SerializedName("musicSize")
    var musicSize: String? = ""
    @SerializedName("name")
    var name: String? = null
    @SerializedName("picId")
    var picId: String? = ""
    @SerializedName("picUrl")
    var picUrl: String? = null
    @SerializedName("trans")
    var trans: String? = null
    class Deserializer : ResponseDeserializable<Artist> {
        override fun deserialize(content: String) = Gson().fromJson(content, Artist::class.java)
    }

}