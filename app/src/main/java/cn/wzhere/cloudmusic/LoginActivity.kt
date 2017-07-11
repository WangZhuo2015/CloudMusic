package cn.wzhere.cloudmusic

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import android.view.View
import android.widget.EditText
import cn.wzhere.cloudmusic.DataModel.User
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        User.get().mContext = applicationContext

        verticalLayout {
            backgroundColor = Color.WHITE
            val phone =editText(){
                hint = "手机号"
                setText(User.get().lastPhone())
            }

            val password = editText(){
                hint = "密码"
            }

            button("登录"){
                onClick {
                    User.get().login(
                            phone.text.toString(),
                            password.text.toString()
                    ){ error ->
                        if (error == null){
                            startActivity<MainActivity>()
                        }else{
                            toast("登录失败:$error")
                        }
                    }
                }
            }
            button("清楚登录信息"){
                onClick {
                    User.get().resetInfo()
                    toast("SUCCESS")
                }
            }

        }


    }
}
