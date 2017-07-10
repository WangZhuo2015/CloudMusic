package cn.wzhere.cloudmusic.DataModel.RankModel

//
//	Album.java
//	Model file generated using JSONExport: https://github.com/Ahmed-Ali/JSONExport

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
import org.json.*
import java.util.*
import com.google.gson.annotations.SerializedName


class Album {

    @SerializedName("alias")
    var alias: Array<Any>? = null
    @SerializedName("artist")
    var artist: Artist? = null
    @SerializedName("artists")
    var artists: Array<Artist>? = null
    @SerializedName("blurPicUrl")
    var blurPicUrl: String? = null
    @SerializedName("briefDesc")
    var briefDesc: String? = null
    @SerializedName("commentThreadId")
    var commentThreadId: String? = null
    @SerializedName("company")
    var company: String? = null
    @SerializedName("companyId")
    var companyId: String? = ""
    @SerializedName("copyrightId")
    var copyrightId: String? = ""
    @SerializedName("description")
    var description: String? = null
    @SerializedName("id")
    var id: String? = ""
    @SerializedName("name")
    var name: String? = null
    @SerializedName("pic")
    var pic: String? = ""
    @SerializedName("picId")
    var picId: String? = ""
    @SerializedName("picId_str")
    var picIdStr: String? = null
    @SerializedName("picUrl")
    var picUrl: String? = null
    @SerializedName("publishTime")
    var publishTime: String? = ""
    @SerializedName("size")
    var size: String? = ""
    @SerializedName("songs")
    var songs: Array<Any>? = null
    @SerializedName("status")
    var status: String? = ""
    @SerializedName("subType")
    var subType: String? = null
    @SerializedName("tags")
    var tags: String? = null
    @SerializedName("type")
    var type: String? = null

    class Deserializer : ResponseDeserializable<Album> {
        override fun deserialize(content: String) = Gson().fromJson(content, Album::class.java)
    }
}