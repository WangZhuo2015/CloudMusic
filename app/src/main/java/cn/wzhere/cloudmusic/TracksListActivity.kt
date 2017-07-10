package cn.wzhere.cloudmusic

import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.*
import android.view.Window
import android.view.WindowManager
import cn.wzhere.cloudmusic.DataModel.RankModel.RankResult
import cn.wzhere.cloudmusic.DataModel.RankModel.Track

import kotlinx.android.synthetic.main.activity_tracks_list.*
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.toolbar
import org.jetbrains.anko.verticalLayout

class TracksListActivity : AppCompatActivity() {
    var tracks: Array<Track>? = null
    var rankResult:RankResult? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_tracks_list)
        //设置全屏
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        //为了添加 toolbar 去掉自带导航
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        rankResult = intent.extras["data"] as RankResult
        tracks = rankResult?.tracks
        val titleStr = rankResult?.creator?.nickname
        val subTitleStr = rankResult?.creator?.signature
        verticalLayout {
            toolbar {
                backgroundColor = Color.DKGRAY
                title = titleStr
                subtitle = subTitleStr
                setTitleTextColor(Color.WHITE)
                setSubtitleTextColor(Color.WHITE)
            }

            recyclerView {
                val myLayoutManager = LinearLayoutManager(context)
                myLayoutManager.orientation = OrientationHelper.VERTICAL
                layoutManager = myLayoutManager
                adapter = TracksListAdapter(tracks!!, { data ->

                })
                itemAnimator = DefaultItemAnimator()
                addItemDecoration(DividerItemDecoration(this@TracksListActivity, LinearLayoutManager.VERTICAL));

                adapter.notifyDataSetChanged()
            }.lparams(matchParent, matchParent)
        }


//        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
//        }
    }

}
