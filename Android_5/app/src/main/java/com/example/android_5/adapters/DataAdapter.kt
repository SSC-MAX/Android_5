package com.example.android_5.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android_5.R
import com.example.android_5.beans.DataBeans


class DataAdapter(val dataList:List<DataBeans>) : RecyclerView.Adapter<DataAdapter.InnerViewHolder>() {

    inner class InnerViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val image : ImageView = view.findViewById(R.id.iv_recycler)
        val title : TextView = view.findViewById(R.id.tv_recycler)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview, parent, false)
        return InnerViewHolder(view)
    }

    override fun onBindViewHolder(holder: InnerViewHolder, position: Int) {
        val data = dataList[position]
        holder.image.setImageBitmap(data.icon)
        holder.title.text = data.title
    }

    override fun getItemCount() = dataList.size
}