package cn.wzhere.cloudmusic

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import cn.wzhere.cloudmusic.DataModel.RankModel.RankResult
import cn.wzhere.cloudmusic.Network.NetworkManager
import com.bumptech.glide.Glide
import kotlinx.coroutines.experimental.runBlocking
import org.jetbrains.anko.*

/**
 * Created by wangzhuo on 2017/7/10.
 */
class RankRecycleAdapter(internal val didSelectedAtPos: (data: RankResult) -> Unit) : RecyclerView.Adapter<RankRecycleAdapter.ViewHolder>() {
    private var mItems = mutableListOf<RankResult>()
    internal var mContext: Context? = null
    private val maxRankId = 21
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context
        return ViewHolder(MatchItemUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        fun bind(model: RankResult) {
            holder.title.text = model.name
            Glide.with(mContext)
                    .load(model.creator?.avatarUrl)
                    .centerCrop()
                    .into(holder.img)
            with(holder.container) {
                setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View) {
                        didSelectedAtPos(mItems[position])
                    }
                })
            }
        }
        val item = mItems[position]
        bind(item)
    }

    override fun getItemCount(): Int {
        //return maxRankId
        return mItems.size
    }

    internal fun loadList(complete: (() -> Unit)?) {
        //TODO -:分批获取详细数据
        loadChannel(0)
    }

    fun loadChannel(idx:Int){
        if (idx>maxRankId) return
        NetworkManager.getRank("$idx"){ data ,err ->
            if (err == null){
                mItems.add(data!!)
                notifyDataSetChanged()
            }else mContext!!.toast("发生错误 $idx 号排行榜加载失败")
            loadChannel(idx+1)
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var container = view.find<FrameLayout>(R.id.RankListItem)
        var img = view.find<ImageView>(R.id.RankListItem_img)
        var title = view.find<TextView>(R.id.RankListItem_title)

    }


    class MatchItemUI : AnkoComponent<ViewGroup> {
        override fun createView(ui: AnkoContext<ViewGroup>): View {
            return with(ui) {
                frameLayout {
                    padding = 10
                    backgroundColor = Color.LTGRAY
                    lparams(width = matchParent, height = wrapContent)
                    frameLayout {
                        id = R.id.RankListItem

                        //图片
                        imageView {
                            backgroundColor = Color.GRAY
                            id = R.id.RankListItem_img
                        }.lparams (width = matchParent, height = matchParent)
                        textView("Title") {
                            textColor = Color.WHITE
                            textSize = 14f
                            id = R.id.RankListItem_title
                        }.lparams(width = matchParent, height = matchParent){
                            bottomMargin = 0
                        }
                    }.lparams(width = dip(180), height = dip(180))
                }
            }
        }
    }
}