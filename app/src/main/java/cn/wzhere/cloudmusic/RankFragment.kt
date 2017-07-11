package cn.wzhere.cloudmusic

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_rank.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.onRefresh
import org.jetbrains.anko.support.v4.toast


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [RankFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [RankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RankFragment : Fragment() {
    var isLoading = false
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater!!.inflate(R.layout.fragment_rank, container, false)
        //rankRecyclerView = rootView.find(R.id.rankRecyclerView)
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val layoutManager = LinearLayoutManager(context)
        //设置布局管理器
        rankRecyclerView!!.layoutManager = GridLayoutManager(context,2)
        //layoutManager
        //设置为垂直布局，这也是默认的
        layoutManager.orientation = OrientationHelper.VERTICAL
        val adapter = RankRecycleAdapter({ data ->
            toast("点击了${data.description}")
            //TODO- 跳转到歌曲列表
            context.startActivity<TracksListActivity>("data" to data)
        })
        //设置Adapter
        rankRecyclerView!!.adapter = adapter
        adapter.mContext = this.context
        //设置增加或删除条目的动画
        rankRecyclerView!!.itemAnimator = DefaultItemAnimator()
        swipe_container.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light, android.R.color.holo_orange_light, android.R.color.holo_green_light)
        swipe_container.onRefresh {
            if (!isLoading) {
                isLoading = true
                adapter.loadList( {
                    swipe_container.isRefreshing = false
                    isLoading = false
                })
            }else toast("别着急,加载ing")
        }

        //开始刷新
        swipe_container.post {
            kotlin.run {
                swipe_container.isRefreshing = true
            }
        }

        //读取一次数据
        adapter.loadList({
            swipe_container.post {
                kotlin.run {
                    swipe_container.isRefreshing = false
                }
            }
        })
    }

}