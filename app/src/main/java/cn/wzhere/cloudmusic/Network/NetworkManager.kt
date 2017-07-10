package cn.wzhere.cloudmusic.Network

import cn.wzhere.cloudmusic.DataModel.RankModel.RankModel
import cn.wzhere.cloudmusic.DataModel.RankModel.RankResult
import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.core.Method
import com.github.kittinunf.result.Result

/**
 * Created by wangzhuo on 2017/7/9.
 */
class NetworkManager {
    companion object {

        //Host
        private fun serviceEndPoint(): String {
            return "http://115.159.70.179:3000"
        }

        //Login 手机号登录接口
        private val phoneLogin = serviceEndPoint() + "/login/cellphone"

        private val rankURL = serviceEndPoint() + "/top/list"


        internal fun getRank(
                idx: String,
                complete: (list: RankResult?, error: FuelError?) -> Unit) {
            FuelManager.instance
                    .request(Method.GET,
                            rankURL,
                            listOf(Pair("idx", idx)))
                                    .responseObject(RankModel.Deserializer()) { request, response, result ->
                                        when (result) {
                                            is Result.Failure -> {
                                                complete(null, result.error)
                                            }
                                            is Result.Success -> {
                                                val (data, err) = result
                                                complete(data!!.result
                                                        , null)
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

//        internal fun login(
//                city: String,
//                complete: (list: Array<HeWeather5>?, error: FuelError?) -> Unit) {
//            FuelManager.instance
//                    .request(Method.GET,
//                            weatherURL,
//                            listOf(
//                                    Pair("key", "bc16930eb4f642588033b094e4a25ad7"),
//                                    Pair("city", city)))
//                    .responseObject(WeatherModel.Deserializer()) { request, response, result ->
//                        when (result) {
//                            is RankResult.Failure -> {
//                                complete(null, result.error)
//                            }
//                            is RankResult.Success -> {
//                                val (data, err) = result
//                                complete(data!!.heWeather5
//                                        , null)
//                            }
//                        }
//                    }
//        }


    }//static
}