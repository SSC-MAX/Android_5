package com.example.android_5.controls

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.widget.LinearLayout
import com.example.android_5.R
import com.example.android_5.adapters.bannerAdapter
import com.youth.banner.Banner
import com.youth.banner.indicator.CircleIndicator



class MyBannerControls(context: Context, attrs:AttributeSet) : LinearLayout(context, attrs) {
    init {
        Log.d("MyBannerControls","构建了")
    }

    private var ifClick = false
    private var downX : Float = 0f
    private var downY : Float = 0f
    private var downTime: Long = 0


    @SuppressLint("ClickableViewAccessibility")
    public fun setData(context: Context, madapter: bannerAdapter, speed:Long, normalColor:String, selectedColor:String, mode:String){
        LayoutInflater.from(context).inflate(R.layout.controls_banner, this, true)
        val mBanner = LayoutInflater.from(context).inflate(R.layout.controls_banner, this, true).findViewById<Banner<*,*>>(R.id.ctrl_mBanner)
        mBanner.adapter = madapter
        mBanner.start()
        mBanner.isAutoLoop(true)
        mBanner.setLoopTime(speed*1000)

        mBanner.setIndicator(CircleIndicator(context))
        mBanner.setIndicatorSelectedColor(Color.parseColor(selectedColor))
        mBanner.setIndicatorNormalColor(Color.parseColor(normalColor))
        if (mode.equals("mode1")){
            mBanner.setBannerGalleryMZ(10)
        }
        if (mode.equals("mode2")){
            mBanner.setBannerGalleryEffect(8,8,10)
        }




        //触摸事件
        mBanner.setOnTouchListener { v, event ->
            val action = event.action
            when(action){
                MotionEvent.ACTION_DOWN -> {
                    downX = event.x
                    downY = event.y
                    downTime = System.currentTimeMillis()
                    mBanner.stop()
                }
                MotionEvent.ACTION_CANCEL, MotionEvent.ACTION_UP -> {
                    var dx = Math.abs(event.x - downX)
                    var dy = Math.abs(event.y - downY)
                    var dTime = System.currentTimeMillis() - downTime
                    ifClick = (dx<=5 && dy<=5 && dTime < 1000)
                    if (ifClick){
                        mBanner.setOnClickListener {
                            Log.d("MainActivity","启动了")
                            mBanner.start()
                        }

                    }
                }
            }
            onTouchEvent(event)
        }

    }




}