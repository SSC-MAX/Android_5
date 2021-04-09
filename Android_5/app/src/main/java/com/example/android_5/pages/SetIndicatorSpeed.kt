package com.example.android_5.pages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_5.R
import com.example.android_5.controls.SetSpeedControls
import kotlinx.android.synthetic.main.activity_set_indicator_speed.*

class SetIndicatorSpeed : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_indicator_speed)

        val ctrl_speed = findViewById<SetSpeedControls>(R.id.ctrl_mSpeed)
        ctrl_speed.setData()
    }
}