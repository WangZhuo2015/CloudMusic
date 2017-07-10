package cn.wzhere.cloudmusic.DataModel.PersonalFMModel

//
//	Privilege.java
//	Model file generated using JSONExport: https://github.com/Ahmed-Ali/JSONExport

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
import org.json.*
import java.util.*
import com.google.gson.annotations.SerializedName


class Privilege {

    @SerializedName("cp")
    var cp: Int = 0
    @SerializedName("cs")
    var isCs: Boolean = false
    @SerializedName("dl")
    var dl: Int = 0
    @SerializedName("fee")
    var fee: Int = 0
    @SerializedName("fl")
    var fl: Int = 0
    @SerializedName("flag")
    var flag: Int = 0
    @SerializedName("id")
    var id: Int = 0
    @SerializedName("maxbr")
    var maxbr: Int = 0
    @SerializedName("payed")
    var payed: Int = 0
    @SerializedName("pl")
    var pl: Int = 0
    @SerializedName("preSell")
    var isPreSell: Boolean = false
    @SerializedName("sp")
    var sp: Int = 0
    @SerializedName("st")
    var st: Int = 0
    @SerializedName("subp")
    var subp: Int = 0
    @SerializedName("toast")
    var isToast: Boolean = false

    class Deserializer : ResponseDeserializable<Privilege> {
        override fun deserialize(content: String) = Gson().fromJson(content, Privilege::class.java)
    }
}