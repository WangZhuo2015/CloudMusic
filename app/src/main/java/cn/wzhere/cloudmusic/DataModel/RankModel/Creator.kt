package cn.wzhere.cloudmusic.DataModel.RankModel

//
//	Creator.java
//	Model file generated using JSONExport: https://github.com/Ahmed-Ali/JSONExport

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
import org.json.*
import java.util.*
import com.google.gson.annotations.SerializedName


class Creator {

    @SerializedName("accountStatus")
    var accountStatus: String? = ""
    @SerializedName("authStatus")
    var authStatus: String? = ""
    @SerializedName("authority")
    var authority: String? = ""
    @SerializedName("avatarImgId")
    var avatarImgId: String? = ""
    @SerializedName("avatarImgIdStr")
    var avatarImgIdStr: String? = ""
    @SerializedName("avatarUrl")
    var avatarUrl: String? = ""
    @SerializedName("backgroundImgId")
    var backgroundImgId: String? = ""
    @SerializedName("backgroundImgIdStr")
    var backgroundImgIdStr: String? = ""
    @SerializedName("backgroundUrl")
    var backgroundUrl: String? = ""
    @SerializedName("birthday")
    var birthday: String? = ""
    @SerializedName("city")
    var city: String? = ""
    @SerializedName("defaultAvatar")
    var isDefaultAvatar: Boolean = false
    @SerializedName("description")
    var description: String? = ""
    @SerializedName("detailDescription")
    var detailDescription: String? = ""
    @SerializedName("djStatus")
    var djStatus: String? = ""
    @SerializedName("expertTags")
    var expertTags: Any? = null
    @SerializedName("followed")
    var isFollowed: Boolean = false
    @SerializedName("gender")
    var gender: String? = ""
    @SerializedName("mutual")
    var isMutual: Boolean = false
    @SerializedName("nickname")
    var nickname: String? = ""
    @SerializedName("province")
    var province: String? = ""
    @SerializedName("remarkName")
    var remarkName: Any? = null
    @SerializedName("signature")
    var signature: String? = ""
    @SerializedName("userId")
    var userId: String? = ""
    @SerializedName("userType")
    var userType: String? = ""
    @SerializedName("vipType")
    var vipType: String? = ""

    class Deserializer : ResponseDeserializable<Creator> {
        override fun deserialize(content: String) = Gson().fromJson(content, Creator::class.java)
    }
}