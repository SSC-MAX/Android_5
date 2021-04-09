package com.example.android_5.controls

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.android_5.R
import com.example.android_5.adapters.DataAdapter
import com.example.android_5.beans.DataBeans


class SetImageControls(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    public fun setDataLinear(dataList: List<DataBeans>) {
        LayoutInflater.from(context).inflate(R.layout.controls_set_image, this, false)
        val mRecyclerView =
            LayoutInflater.from(context).inflate(R.layout.controls_set_image, this, true)
                .findViewById<RecyclerView>(R.id.rv_chooseImage)
        val layoutManger = StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL)
        mRecyclerView.layoutManager = layoutManger
        val adapter = DataAdapter(dataList)
        mRecyclerView.adapter = adapter
    }

}