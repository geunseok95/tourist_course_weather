package com.professionalandroid.apps.touristspotweather

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.professionalandroid.apps.touristspotweather.MainActivity.Companion.course_list
import kotlinx.android.synthetic.main.fragment_recyclerview_page.view.*

class RecyclerviewPage(private var course_spot_list: item?) : Fragment(), RecyclerViewAdapter.OnListItemSelelctedInterface  {

    lateinit var mRecyclerView: RecyclerView
    var mRecyclerAdapter: RecyclerViewAdapter? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mRecyclerAdapter =  RecyclerViewAdapter(context,this, course_spot_list!!)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment
            val view =  inflater.inflate(R.layout.fragment_recyclerview_page, container, false)
            mRecyclerView = view.fragment_recyclerview as RecyclerView
            mRecyclerView.layoutManager = LinearLayoutManager(context)
            mRecyclerView.adapter = mRecyclerAdapter

        return view
    }

    override fun onItemSelected(v: View, position: Int) {
        v.setOnClickListener {
            val weater_detail_page = WeatherDetailFragment(course_spot_list!!.item[position], position)
            (activity as MainActivity).move_next_fragment(weater_detail_page)
        }
    }

}