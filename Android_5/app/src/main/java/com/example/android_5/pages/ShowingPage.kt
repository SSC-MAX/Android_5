package com.example.android_5.pages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.android_5.R
import com.example.android_5.adapters.bannerAdapter
import com.example.android_5.controls.MyBannerControls



class ShowingPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_showing_page)

        val normalColor = intent.getStringExtra("normalColor")!!
        val selectedColor = intent.getStringExtra("selectedColor")!!
        val speed = intent.getStringExtra("speed")!!.toLong()
        val mode = intent.getStringExtra("mode")!!

        val com_Banner = findViewById<MyBannerControls>(R.id.ctrl_mBannerShowing)
        val adapter = bannerAdapter(SetImages.dataList)
        com_Banner.setData(this,adapter, speed, normalColor, selectedColor, mode)

    }
}
