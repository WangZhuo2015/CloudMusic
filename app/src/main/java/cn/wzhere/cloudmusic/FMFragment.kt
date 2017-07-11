package cn.wzhere.cloudmusic

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import cn.wzhere.cloudmusic.DataModel.PersonalFMModel.FMData
import cn.wzhere.cloudmusic.Network.NetworkManager
import com.bumptech.glide.Glide
import org.jetbrains.anko.*
import org.jetbrains.anko.support.v4.UI
import org.jetbrains.anko.support.v4.find
import com.bumptech.glide.request.animation.GlideAnimation
import android.graphics.Bitmap
import android.media.AudioManager
import android.media.MediaPlayer
import android.net.Uri
import android.view.Gravity
import android.widget.SeekBar
import com.bumptech.glide.request.target.SimpleTarget
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.support.v4.toast


/**
 * Created by wangzhuo on 2017/7/10.
 */
class FMFragment : Fragment() {
    var isLoading = false
    val player = MediaPlayer()
    var musicList: Array<FMData>? = null
    var lock = false
    var playing = false


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
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
                    }.lparams(dip(200), dip(200)) {
                        gravity = Gravity.CENTER_HORIZONTAL
                    }
                    linearLayout {
                        button("前一首")
                        button("播放") {

                            onClick {
                                playing = !playing
                                if (playing) {
                                    play()
                                    text = "暂停"
                                } else {
                                    pause()
                                    text = "播放"
                                }

                            }
                        }
                        button("下一首") {
                            onClick {
                                next()
                            }
                        }
                    }
                    seekBar {
                        id = R.id.FM_Progress
                    }


                }.lparams(matchParent, matchParent)
            }
        }.view


        player.setOnBufferingUpdateListener { mediaPlayer, i ->
            find<SeekBar>(R.id.MUSIC_Progress).secondaryProgress = i
            toast("加载进度 $i")
        }
        
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        requestFM()
    }

    fun requestFM() {
        player.stop()
        NetworkManager.loadFM { list, error ->
            if (error == null) {
                musicList = list?.data
                NetworkManager.findMp3ById(musicList!![0].id) { song, error ->
                    refreshUI()
                    autoPlaySong(song!!.data!![0].url!!)
                }
                toast("加载 ${musicList!![0].name}")
            }else{
                toast("出错了 ${error}")
                requestFM()
            }
        }
    }

    fun autoPlaySong(url: String) {
        player.stop()
        player.reset()
        player.setAudioStreamType(AudioManager.STREAM_MUSIC)
        player.setDataSource(context, Uri.parse(url))
        player.prepareAsync()
        player.setOnPreparedListener { mediaPlayer ->
            mediaPlayer.start()
        }


    }

    fun play() {
        if (player.isPlaying) {
            player.start()
        }
    }

    fun pause() {
        player.pause()
    }

    fun next() {
        requestFM()
    }

    fun refreshUI() {
        val bg = find<ImageView>(R.id.FM_BG)
        val img = find<ImageView>(R.id.FM_Img)
        val title = find<TextView>(R.id.FM_Title)
        val subTitle = find<TextView>(R.id.FM_SubTitle)

        val item = musicList!![0]
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

    override fun onDestroy() {
        super.onDestroy()
        player.release()
    }
}