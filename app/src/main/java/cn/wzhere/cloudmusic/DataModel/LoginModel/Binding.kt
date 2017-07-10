package cn.wzhere.cloudmusic.DataModel

//
//	Binding.java
//	Model file generated using JSONExport: https://github.com/Ahmed-Ali/JSONExport

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
import org.json.*
import java.util.*
import com.google.gson.annotations.SerializedName


class Binding{

    @SerializedName("expired")
    var isExpired: Boolean = false
    @SerializedName("expiresIn")
    var expiresIn:String = ""
    @SerializedName("id")
    var id:String = ""
    @SerializedName("refreshTime")
    var refreshTime:String = ""
    @SerializedName("tokenJsonStr")
    var tokenJsonStr: String? = null
    @SerializedName("type")
    var type:String = ""
    @SerializedName("url")
    var url: String? = null
    @SerializedName("userId")
    var userId:String = ""

    class Deserializer : ResponseDeserializable<Binding> {
        override fun deserialize(content: String) = Gson().fromJson(content, Binding::class.java)
    }
}