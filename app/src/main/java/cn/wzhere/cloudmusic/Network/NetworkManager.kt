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


        var music_u = ""
        var cookie = "__remember_me=true; MUSIC_U=cc3a183ff50cb7aad64191d891f2cd8720df35b3e4b78fe10eb21ab4a88f1fc75cae9f78217c06b18e5e99b95265e89a637a6af13fed428e8bafcdfe5ad2b092; __csrf=4273e98f5d114c6edb62fa1defec5db1"
        var cookies: String = ""
        public var httpCookies = mutableListOf<HttpCookie>()
        //Host
        private fun host(): String {
            return "http://115.159.70.179:3000"
        }

        //Login 手机号登录接口
        private val phoneLogin = host() + "/login/cellphone"

        private val rankURL = host() + "/top/list"

        private val fmURL = host() + "/personal_fm"

        private val idUrl = host() + "/music/url"


        fun setAuthCookies(cookies: String){
            this.cookies = cookies
        }

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

        //失败 {"msg":"帐号不存在","code":501}
        //

//        {
//            "msg": "ip高频",
//            "code": 415,
//            "captchaId": "LcsUkoNoMZiXGNmvF4rPks3G"
//        }

        internal fun login(
                phone: String,
                password: String,
                complete: (loginModel: LoginModel?,cookies:String, error: FuelError?) -> Unit) {
            FuelManager.instance
                    .request(Method.GET, phoneLogin,
                            listOf(Pair("phone", phone),
                                    Pair("password", password)))
                    .responseObject(LoginModel.Deserializer()) { request, response, result ->
                        when (result) {
                            is Result.Failure -> {
                                complete(null,"", result.error)
                            }
                            is Result.Success -> {
                                //Set-Cookie
                                cookies = response.httpResponseHeaders
                                        .filter { it.key.equals("Set-Cookie", true) }
                                        .values.first()
                                        .reduce { l, r -> l.substring(0, l.indexOf(';') + 1) + " " + r }

//                                response.httpResponseHeaders
//                                        .map { it.key.equals("Set-Cookie", true) }
//                                        .first()


//                                        .filter { it.key.equals("Set-Cookie",true) }
//                                        .values
//                                        .first()
//                                        .forEach{httpCookies.plus(HttpCookie.parse(it))}
                                FuelManager.instance.baseHeaders = mapOf("Cookie" to cookies)
//                                music_u = response.httpResponseHeaders
//                                        .filter { it.key.startsWith("Set-Cookie") }.values.first()
//                                        .filter { it.startsWith("MUSIC_U=") }.first()

                                val (data, err) = result
                                complete(data!!, cookies, null)
                            }
                        }
                    }
        }


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