package cn.wzhere.cloudmusic

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import cn.wzhere.cloudmusic.DataModel.RankModel.Track
import cn.wzhere.cloudmusic.Network.NetworkManager
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

/**
 * Created by wangzhuo on 2017/7/10.
 */
class TracksListAdapter(val mItems: Array<Track>,
                        internal val didSelectedAtPos: (data: Track) -> Unit) : RecyclerView.Adapter<TracksListAdapter.ViewHolder>() {
    internal var mContext: Context? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context
        return ViewHolder(MatchItemUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        fun bind(model: Track) {
            holder.title.text = model.name
            holder.subTitle.text = model?.artists!![0].name + " - " + model.album?.name
            holder.no.text = "$position"
            Glide.with(mContext)
                    .load(model.album?.picUrl)
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher_foreground) // will be displayed if the image cannot be loaded
                    .dontAnimate()
                    .centerCrop()
                    .into(holder.img)

            with(holder.container) {
                setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View) {
                        didSelectedAtPos(mItems!![position])
                    }
                })
            }
        }

        val item = mItems!![position]
        bind(item)
    }

    override fun getItemCount(): Int {
        //return maxRankId
        return mItems!!.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var container = view.find<LinearLayout>(R.id.TracksListItem)
        var img = view.find<ImageView>(R.id.TracksListItem_img)
        var title = view.find<TextView>(R.id.TracksListItem_title)
        var subTitle = view.find<TextView>(R.id.TracksListItem_subTitle)
        var no = view.find<TextView>(R.id.TracksListItem_no)
    }


    class MatchItemUI : AnkoComponent<ViewGroup> {
        override fun createView(ui: AnkoContext<ViewGroup>): View {
            return with(ui) {
                linearLayout {
                    id = R.id.TracksListItem
                    textView("01"){
                        textColor = Color.DKGRAY
                        textSize = 30F
                        id = R.id.TracksListItem_no
                    }.lparams(width = dip(40), height = dip(40))


                    //图片
                    imageView {
                        backgroundColor = Color.GRAY
                        id = R.id.TracksListItem_img
                    }.lparams(width = dip(70), height = dip(70))

                    verticalLayout {
                        textView("Title") {
                            textColor = Color.BLACK
                            textSize = 20f
                            id = R.id.TracksListItem_title
                        }
                        textView("SubTitle") {
                            textColor = Color.BLACK
                            textSize = 14f
                            id = R.id.TracksListItem_subTitle
                        }
                    }

                }
            }

        }
    }
}