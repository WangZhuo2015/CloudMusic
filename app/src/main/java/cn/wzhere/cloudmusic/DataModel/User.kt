package cn.wzhere.cloudmusic.DataModel

/**
 * Created by wangzhuo on 2017/7/9.
 */
class User private constructor(){

    var userId = ""
    var userName = ""
    var token = ""
    companion object {
        fun get(): User {
            return Inner.single
        }
    }

    private object Inner{
        val single  = User()
    }

    fun login(id:String,name:String,token:String){
        userId = id
        userName = name
        this.token = token
    }
}