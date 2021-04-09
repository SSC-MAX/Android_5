package com.example.android_5.adapters

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android_5.R
import com.example.android_5.beans.DataBeans

import kotlinx.android.synthetic.main.layout_show_details.view.*
import com.youth.banner.adapter.BannerAdapter


 class bannerAdapter(data:List<DataBeans>) : BannerAdapter<DataBeans,bannerAdapter.innerHolder>(data){

    inner class innerHolder(view: View) : RecyclerView.ViewHolder(view){
        val image : ImageView = itemView.findViewById(R.id.iv_banner)
    }

    override fun onCreateHolder(parent: ViewGroup?, viewType: Int): innerHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_banner, parent, false)
        val myHolder = innerHolder(view)

//
//
//
////        myHolder.image.setOnClickListener {
////            val intent = Intent(parent?.context, JumpTest::class.java)
////            parent?.context?.startActivity(intent)
////        }
        return myHolder

    }


    override fun onBindView(holder: innerHolder?, data: DataBeans?, position: Int, size: Int) {
        val mycontext = holder?.itemView?.context
        if (data != null) {
            Log.d("bannerAdapter","确实，列表不为空")
            holder?.image?.setImageBitmap(data.icon)

            //点击事件
            holder?.itemView?.setOnClickListener {
                val detailView = LayoutInflater.from(mycontext).inflate(R.layout.layout_show_details, null)
                detailView.iv_jump.setImageBitmap(data.icon)
                detailView.tv_jump.text = data.title
                AlertDialog.Builder(mycontext).apply {
                    setTitle("详细信息")
                    setView(detailView)
                    setNegativeButton("取消"){dialog, which ->}
                    show()
                }
            }

        }else{
            Log.d("bannerAdapter","不对，列表为空")
        }
    }





}