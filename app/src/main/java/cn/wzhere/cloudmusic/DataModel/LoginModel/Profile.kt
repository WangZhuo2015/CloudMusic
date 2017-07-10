package cn.wzhere.cloudmusic.DataModel

//
//	Profile.java
//	Model file generated using JSONExport: https://github.com/Ahmed-Ali/JSONExport

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
import org.json.*
import java.util.*
import com.google.gson.annotations.SerializedName


class Profile {

    @SerializedName("accountStatus")
    var accountStatus:String = ""
    @SerializedName("authStatus")
    var authStatus:String = ""
    @SerializedName("authority")
    var authority:String = ""
    @SerializedName("avatarImgId")
    var avatarImgId:String = ""
    @SerializedName("avatarImgIdStr")
    var avatarImgIdStr: String? = null
    @SerializedName("avatarUrl")
    var avatarUrl: String? = null
    @SerializedName("backgroundImgId")
    var backgroundImgId:String = ""
    @SerializedName("backgroundImgIdStr")
    var backgroundImgIdStr: String? = null
    @SerializedName("backgroundUrl")
    var backgroundUrl: String? = null
    @SerializedName("birthday")
    var birthday:String = ""
    @SerializedName("city")
    var city:String = ""
    @SerializedName("defaultAvatar")
    var isDefaultAvatar: Boolean = false
    @SerializedName("description")
    var description: String? = null
    @SerializedName("detailDescription")
    var detailDescription: String? = null
    @SerializedName("djStatus")
    var djStatus:String = ""
    @SerializedName("expertTags")
    var expertTags: Any? = null
    @SerializedName("followed")
    var isFollowed: Boolean = false
    @SerializedName("gender")
    var gender:String = ""
    @SerializedName("mutual")
    var isMutual: Boolean = false
    @SerializedName("nickname")
    var nickname: String? = null
    @SerializedName("province")
    var province:String = ""
    @SerializedName("remarkName")
    var remarkName: Any? = null
    @SerializedName("signature")
    var signature: String? = null
    @SerializedName("userId")
    var userId:String = ""
    @SerializedName("userType")
    var userType:String = ""
    @SerializedName("vipType")
    var vipType:String = ""

    class Deserializer : ResponseDeserializable<Profile> {
        override fun deserialize(content: String) = Gson().fromJson(content, Profile::class.java)
    }
}