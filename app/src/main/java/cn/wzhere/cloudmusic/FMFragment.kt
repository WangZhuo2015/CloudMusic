package cn.wzhere.cloudmusic

import android.media.AsyncPlayer
import android.media.MediaPlayer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import cn.wzhere.cloudmusic.DataModel.PersonalFMModel.Data
import cn.wzhere.cloudmusic.Network.NetworkManager
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_rank.*
import org.jetbrains.anko.*
import org.jetbrains.anko.support.v4.UI
import org.jetbrains.anko.support.v4.find
import org.jetbrains.anko.support.v4.onRefresh
import org.jetbrains.anko.support.v4.toast
import java.net.HttpCookie
import com.bumptech.glide.request.animation.GlideAnimation
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.renderscript.Allocation
import android.renderscript.RenderScript
import android.renderscript.ScriptIntrinsicBlur
import android.widget.ProgressBar
import com.bumptech.glide.request.target.SimpleTarget
import com.fivehundredpx.android.blur.BlurringView
import org.jetbrains.anko.sdk25.coroutines.onClick
import java.net.URI
import java.net.URL


/**
 * Created by wangzhuo on 2017/7/10.
 */
class FMFragment : Fragment() {
    var isLoading = false
    val player: MediaPlayer = MediaPlayer()
    var musicList: Array<Data>? = null
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var playing = false
        return UI {
            frameLayout {
                imageView() {
                    id = R.id.FM_BG
                }.lparams(matchParent, matchParent)
                verticalLayout {
                    textView() {
                        id = R.id.FM_Title
                    }
                    textView() {
                        id = R.id.FM_SubTitle
                    }
                    imageView() {
                        id = R.id.FM_Img
                    }.lparams(dip(400), dip(400)) {

                    }
                    linearLayout {
                        button("前一首")
                        button("播放"){

                            onClick {
                                playing = !playing
                                if(playing){
                                    play()
                                    text = "暂停"
                                }
                                else {
                                    pause()
                                    text = "播放"
                                }

                            }
                        }
                        button("下一首")
                    }
                    horizontalProgressBar {
                        id = R.id.FM_Progress
                    }


                }.lparams(matchParent, matchParent)
            }
        }.view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        NetworkManager.login("13151190802", "wang730000", { data, err ->
            print(data)
            NetworkManager.loadFM { list, error ->
                print(list)
                musicList = list?.data
                refreshUI()
            }
        })


        player.setOnBufferingUpdateListener{ player,percentage ->
            val progress = find<ProgressBar>(R.id.FM_Progress)
            progress.max = 100
            progress.min = 0
            progress.progress = percentage
        }
    }

    fun play(){
        val item = musicList!![1]
        player.reset()
        player.setDataSource("http://219.138.125.22/myweb/mp3/CMP3/JH19.MP3")//item.mp3Url)
        player.prepare()
    }
    fun pause(){
        player.pause()
    }

    fun refreshUI() {
        val bg = find<ImageView>(R.id.FM_BG)
        val img = find<ImageView>(R.id.FM_Img)
        val title = find<TextView>(R.id.FM_Title)
        val subTitle = find<TextView>(R.id.FM_SubTitle)

        val item = musicList!![1]
        title.text = item.name
        subTitle.text = item.artists!![0].name


        val target = (object : SimpleTarget<Bitmap>() {
            override fun onResourceReady(resource: Bitmap?, glideAnimation: GlideAnimation<in Bitmap>?) {
                //        scaledBitmap为目标图像，10是缩放的倍数（越大模糊效果越高）
                val blurBitmap = FastBlurUtil.toBlur(resource, 10);
                bg.setScaleType(ImageView.ScaleType.CENTER_CROP);
                bg.setImageBitmap(blurBitmap);
            }
        })

        Glide.with(context)
                .load(item.album?.picUrl)
                .asBitmap()
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher_foreground) // will be displayed if the image cannot be loaded
                .dontAnimate()
                .centerCrop()
                .into(target)
        Glide.with(context)
                .load(item.album?.picUrl)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher_foreground) // will be displayed if the image cannot be loaded
                .dontAnimate()
                .centerCrop()
                .into(img)
    }
}