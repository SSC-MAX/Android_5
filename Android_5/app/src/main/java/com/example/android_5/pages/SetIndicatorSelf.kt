package com.example.android_5.pages


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_5.R
import com.example.android_5.controls.SetIndicatorSelfControls

class SetIndicatorSelf : AppCompatActivity() {

    companion object{

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_indicator_self)
        val indicatorSpeed = intent.getStringExtra("speedChosen")!!
        val setIndicatorSelfCrtl = findViewById<SetIndicatorSelfControls>(R.id.ctrl_setIndicatorSelfControls)
        setIndicatorSelfCrtl.setData(indicatorSpeed)
    }
}