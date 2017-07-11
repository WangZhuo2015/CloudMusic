package cn.wzhere.cloudmusic.DataModel;

import android.content.Context
import cn.wzhere.cloudmusic.Network.NetworkManager

/**
 * Created by wangzhuo on 2017/7/9.
 */
class User private constructor(){

    var mContext:Context? = null
    val cookieKey = "COOKIE"
    val phoneKey = "PHONE"
    companion object {
        fun get(): User {
            return Inner.single
        }
    }

    private object Inner{
        val single  = User()
    }

    fun login(phone:String,password:String,completionHandler:(error:String?)->Unit){
        val lastPhone = loadInfo(phoneKey)
        if (phone == lastPhone){
            NetworkManager.setAuthCookies(loadInfo(cookieKey))
            completionHandler(null)
        }else{
            NetworkManager.login(phone,password){ data,cookies,err->
                if (err == null) {
                    //正常
                    saveInfo(cookieKey,cookies)
                    saveInfo(phoneKey,phone)
                    NetworkManager.setAuthCookies(cookies)
                    completionHandler(null)
                }else{
                    //有错
                    completionHandler(err.toString())
                }
            }
        }
    }

    //通过SharedPreferences保存信息
    private fun saveInfo(key:String,info: String) {
        //打开Preferences，Cookie，如果存在则打开它，否则创建新的Preferences
        val preferences = mContext!!.getSharedPreferences("User", Context.MODE_PRIVATE)
        //让setting处于编辑状态
        val editor = preferences.edit()
        //保存位置数据
        editor.putString(key, info)
        //提交保存到磁盘
        editor.commit()
    }

    //从SharedPreferences取出cookie信息
    private fun loadInfo(key:String): String {
        //打开Preferences
        val preferences = mContext!!.getSharedPreferences("User", Context.MODE_PRIVATE)
        //从文件中获取数据
        val info = preferences.getString(key, "")
        return info
    }
}