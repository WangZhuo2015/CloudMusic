package cn.wzhere.cloudmusic.Network

import android.content.Context
import cn.wzhere.cloudmusic.DataModel.LoginModel
import cn.wzhere.cloudmusic.DataModel.PersonalFMModel.FMModel
import cn.wzhere.cloudmusic.DataModel.RankModel.RankModel
import cn.wzhere.cloudmusic.DataModel.RankModel.RankResult
import cn.wzhere.cloudmusic.DataModel.SongModel.SongModel
import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.core.Method
import com.github.kittinunf.result.Result
import java.net.HttpCookie


import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

/**
 * Created by wangzhuo on 2017/7/9.
 */
class NetworkManager {
    companion object {
        //用于储存 Cookie 信息
        var cookies: String = ""

        //Host
        private fun host(): String {
            return "http://115.159.70.179:3000"
        }

        //Login 手机号登录接口
        private val phoneLogin = host() + "/login/cellphone"
        //排行榜接口
        private val rankURL = host() + "/top/list"
        //私人 FM
        private val fmURL = host() + "/personal_fm"
        //根据 id 获取 URL
        private val idUrl = host() + "/music/url"
        //喜欢歌曲
        private val likeUrl = host() + "/like"

        //设置Cookie
        fun setAuthCookies(cookies: String) {
            this.cookies = cookies
            FuelManager.instance.baseHeaders = mapOf("Cookie" to cookies)

        }

        //    获取排行榜信息
        //    接口地址 :https://http://115.159.70.179:3000/top/list
        //    请求方法 :GET
        //    请求参数(url) :
        //          idx: 排行榜编号
        //    /top/list?idx=1
        internal fun getRank(
                idx: String,
                complete: (list: RankResult?, error: FuelError?) -> Unit) {
            FuelManager.instance
                    .request(Method.GET, rankURL, listOf(Pair("idx", idx)))
                    .responseObject(RankModel.Deserializer()) { request, response, result ->
                        when (result) {
                            is Result.Failure -> {
                                complete(null, result.error)
                            }
                            is Result.Success -> {
                                val (data, err) = result
                                complete(data!!.result, null)
                            }
                        }
                    }
        }


        //    手机账号登录网易云音乐账号
        //    接口地址 :https://http://115.159.70.179:3000/
        //    请求方法 :GET
        //    请求参数(url) :
        //          phone: 手机号码
        //          password: 密码
        //    /login/cellphone?phone=xxx&password=yyy
        internal fun login(
                phone: String,
                password: String,
                complete: (loginModel: LoginModel?, cookies: String, error: FuelError?) -> Unit) {
            FuelManager.instance
                    .request(Method.GET, phoneLogin,
                            listOf(Pair("phone", phone),
                                    Pair("password", password)))
                    .responseObject(LoginModel.Deserializer()) { request, response, result ->
                        when (result) {
                            is Result.Failure -> {
                                complete(null, "", result.error)
                            }
                            is Result.Success -> {
                                /**
                                 * 从请求头获取 Cookie 信息
                                 */
                                val cookies = response.httpResponseHeaders
                                        .filter { it.key.equals("Set-Cookie", true) }
                                        .values
                                        .first()
                                        .map { it.substring(0, it.indexOf(';') + 1) }
                                        .reduce { l, r -> l + r }

                                val (data, err) = result
                                complete(data!!, cookies, null)
                            }
                        }
                    }
        }

        //    喜欢歌曲
        //    接口地址 :https://http://115.159.70.179:3000/music/url
        //    请求方法 :GET
        //    请求参数(url) :
        //          id:  歌曲 id
        //    /like
        fun likeId(id: String,
                   complete: (success: String) -> Unit) {
            FuelManager.instance
                    .request(Method.GET, likeUrl, listOf(Pair("id", id))).responseString { request, response, result ->
                complete(result.get())
            }
        }


        //    私人 FM 接口
        //    接口地址 :https://http://115.159.70.179:3000/personal_fm
        //    请求方法 :GET
        //    请求参数(url) : 无
        //    /personal_fm
        fun loadFM(complete: (list: FMModel?, error: FuelError?) -> Unit) {
            FuelManager.instance
                    .request(Method.GET, fmURL, listOf())
                    .responseObject(FMModel.Deserializer()) { request, response, result ->
                        print(result.component1())
                        when (result) {
                            is Result.Failure -> {
                                complete(null, result.error)
                            }
                            is Result.Success -> {
                                val (data, err) = result
                                complete(data!!, null)
                            }
                        }
                    }
        }

        //    根据音乐 ID 获取 URL 数据
        //    接口地址 :https://http://115.159.70.179:3000/music/url
        //    请求方法 :GET
        //    请求参数(url) :
        //          id:  歌曲 id
        //    /music/url
        fun findMp3ById(id: String,
                        complete: (song: SongModel?, error: FuelError?) -> Unit) {
            FuelManager.instance
                    .request(Method.GET, idUrl, listOf(Pair("id", id)))
                    .responseObject(SongModel.Deserializer()) { request, response, result ->
                        print(result.component1())
                        when (result) {
                            is Result.Failure -> {
                                complete(null, result.error)
                            }
                            is Result.Success -> {
                                val (data, err) = result
                                complete(data!!, null)
                            }
                        }
                    }
        }

    }//static
}