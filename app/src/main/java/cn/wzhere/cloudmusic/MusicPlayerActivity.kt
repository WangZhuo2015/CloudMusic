package cn.wzhere.cloudmusic

import android.graphics.Bitmap
import android.media.AudioManager
import android.media.MediaPlayer
import android.net.Network
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import cn.wzhere.cloudmusic.DataModel.RankModel.Track
import cn.wzhere.cloudmusic.Network.NetworkManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.animation.GlideAnimation
import com.bumptech.glide.request.target.SimpleTarget
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.support.v4.find
import org.jetbrains.anko.support.v4.toast

class MusicPlayerActivity : AppCompatActivity() {
    var isLoading = false
    val player = MediaPlayer()
    var musicList: Array<Track>? = null
    var lock = false
    var playing = false
    var idx = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        idx = intent.extras["idx"] as Int
        musicList = intent.extras["list"] as Array<Track>

        frameLayout {
            imageView() {
                id = R.id.MUSIC_BG
            }.lparams(matchParent, matchParent)
            verticalLayout {
                textView() {
                    id = R.id.MUSIC_Title
                }
                textView() {
                    id = R.id.MUSIC_SubTitle
                }
                imageView() {
                    id = R.id.MUSIC_Img
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
                    id = R.id.MUSIC_Progress
                }
            }.lparams(matchParent, matchParent)
        }

        refreshUI()
        playById(musicList!![idx].id!!)
    }

    fun playById(idx:String){
        NetworkManager.findMp3ById(idx){song, error ->
            autoPlaySong(song!!.data!![0].url!!)
        }
    }

    fun autoPlaySong(url: String) {
        player.stop()
        player.reset()
        player.setAudioStreamType(AudioManager.STREAM_MUSIC)
        player.setDataSource(this, Uri.parse(url))
        player.prepareAsync()
        player.setOnPreparedListener { mediaPlayer ->
            mediaPlayer.start()
        }
        player.setOnBufferingUpdateListener { mediaPlayer, i ->
            toast("加载进度 $i")
        }
    }

    fun play() {
        if (!player.isPlaying) {
            player.start()
        }else{
            refreshUI()
            autoPlaySong(musicList!![idx].id!!)
        }
    }

    fun pause() {
        player.pause()
    }

    fun next() {


    }

    fun refreshUI() {
        val bg = find<ImageView>(R.id.MUSIC_BG)
        val img = find<ImageView>(R.id.MUSIC_Img)
        val title = find<TextView>(R.id.MUSIC_Title)
        val subTitle = find<TextView>(R.id.MUSIC_SubTitle)

        val item = musicList!![idx]
        title.text = item.name
        subTitle.text = item.artists!![0].name

        val target = (object : SimpleTarget<Bitmap>() {
            override fun onResourceReady(resource: Bitmap?, glideAnimation: GlideAnimation<in Bitmap>?) {
                //scaledBitmap为目标图像，10是缩放的倍数（越大模糊效果越高）
                val blurBitmap = FastBlurUtil.toBlur(resource, 10);
                bg.setScaleType(ImageView.ScaleType.CENTER_CROP);
                bg.setImageBitmap(blurBitmap);
            }
        })

        Glide.with(this)
                .load(item.album?.picUrl)
                .asBitmap()
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher_foreground) // will be displayed if the image cannot be loaded
                .dontAnimate()
                .centerCrop()
                .into(target)
        Glide.with(this)
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
