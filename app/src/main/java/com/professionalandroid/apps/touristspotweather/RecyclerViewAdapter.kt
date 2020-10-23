package com.professionalandroid.apps.touristspotweather

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class RecyclerViewAdapter(private var list: item):
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    interface OnListItemSelelctedInterface{
        fun onItemSelected(v: View, position: Int)
    }

    private var mlistener: OnListItemSelelctedInterface? = null

    constructor(context: Context, listener: OnListItemSelelctedInterface, list: item) : this(list) {
        this.mlistener = listener
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val inflateView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(inflateView)
    }

    override fun getItemCount(): Int {
        return list.item.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.spot_name?.text = list.item[position].spotName
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        var parentview =view
        var spot_name: TextView? = null

        init {
            spot_name = view.spot_name
            parentview.setOnClickListener {
                mlistener?.onItemSelected(view, adapterPosition)
            }
        }

        override fun toString(): String {
            return super.toString() + " '" + spot_name!!.text + "'"
        }
    }
}