package cn.wzhere.cloudmusic.DataModel

//
//	Account.java
//	Model file generated using JSONExport: https://github.com/Ahmed-Ali/JSONExport

import cn.wzhere.cloudmusic.DataModel.RankModel.Artist
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
import org.json.*
import java.util.*
import com.google.gson.annotations.SerializedName


class Account {

    @SerializedName("anonimousUser")
    var isAnonimousUser: Boolean = false
    @SerializedName("ban")
    var ban:String = ""
    @SerializedName("baoyueVersion")
    var baoyueVersion:String = ""
    @SerializedName("createTime")
    var createTime:String = ""
    @SerializedName("donateVersion")
    var donateVersion:String = ""
    @SerializedName("id")
    var id:String = ""
    @SerializedName("salt")
    var salt: String? = null
    @SerializedName("status")
    var status:String = ""
    @SerializedName("tokenVersion")
    var tokenVersion:String = ""
    @SerializedName("type")
    var type:String = ""
    @SerializedName("userName")
    var userName: String? = null
    @SerializedName("vipType")
    var vipType:String = ""
    @SerializedName("viptypeVersion")
    var viptypeVersion:String = ""
    @SerializedName("whitelistAuthority")
    var whitelistAuthority:String = ""

    class Deserializer : ResponseDeserializable<Account> {
        override fun deserialize(content: String) = Gson().fromJson(content, Account::class.java)
    }
}