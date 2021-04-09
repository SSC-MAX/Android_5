package com.example.android_5.controls

import android.content.Context
import android.content.Intent
import android.text.TextUtils
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.example.android_5.R
import com.example.android_5.pages.SetIndicatorSelf
import kotlinx.android.synthetic.main.controls_set_speed.view.*

class SetSpeedControls(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    lateinit var mSpeed : String

    public fun setData() {
        LayoutInflater.from(context).inflate(R.layout.controls_set_speed, this)

        bt_speed1.setOnClickListener {
            val intent = Intent(context, SetIndicatorSelf::class.java)
            intent.putExtra("speedChosen", "1")
            context.startActivity(intent)
        }

        bt_speed2.setOnClickListener {
            val intent = Intent(context, SetIndicatorSelf::class.java)
            intent.putExtra("speedChosen", "2")
            context.startActivity(intent)
        }

        bt_speed3.setOnClickListener {
            val intent = Intent(context, SetIndicatorSelf::class.java)
            intent.putExtra("speedChosen", "3")
            context.startActivity(intent)
        }


        et_speed.addTextChangedListener {
            mSpeed = et_speed.text.toString()
            if (mSpeed!=""){
                if (mSpeed.toDouble()>2){
                    bt_speedSelf.isEnabled = true
                }else{
                    Toast.makeText(context,"请输入大于2的数字",Toast.LENGTH_SHORT).show()
                }

            }else{
                Log.d("SetSpeedControls","就是空的")
            }

        }

        bt_speedSelf.setOnClickListener {
            val intent = Intent(context, SetIndicatorSelf::class.java)
            intent.putExtra("speedChosen", mSpeed)
            context.startActivity(intent)
        }

    }
}