package cn.wzhere.cloudmusic

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import cn.wzhere.cloudmusic.DataModel.RankModel.Track

import kotlinx.android.synthetic.main.activity_tracks_list.*

class TracksListActivity : AppCompatActivity() {
    var tracks: Array<Track>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tracks_list)
        setSupportActionBar(toolbar)
        tracks = intent.extras["tracks"] as Array<Track>

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }


    }

}
