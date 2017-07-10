package cn.wzhere.cloudmusic.DataModel

//
//	LoginModel.java
//	Model file generated using JSONExport: https://github.com/Ahmed-Ali/JSONExport

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
import org.json.*
import java.util.*
import com.google.gson.annotations.SerializedName


class LoginModel{

    @SerializedName("account")
    var account: Account? = null
    @SerializedName("bindings")
    var bindings: Array<Binding>? = null
    @SerializedName("code")
    var code:String = ""
    @SerializedName("loginType")
    var loginType:String = ""
    @SerializedName("profile")
    var profile: Profile? = null
    class Deserializer : ResponseDeserializable<LoginModel> {
        override fun deserialize(content: String) = Gson().fromJson(content, LoginModel::class.java)
    }
}