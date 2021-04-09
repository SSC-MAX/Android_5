package com.example.android_5.controls

import android.content.Context
import android.content.Intent
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.widget.*
import com.example.android_5.R
import com.example.android_5.pages.ShowingPage
import kotlinx.android.synthetic.main.controls_set_indicator_self.view.*

class SetIndicatorSelfControls(context: Context, attrs:AttributeSet) : LinearLayout(context, attrs){

    lateinit var normalColor:String
    lateinit var selectedColor:String
    lateinit var mode:String

    public fun setData(speed:String){
        LayoutInflater.from(context).inflate(R.layout.controls_set_indicator_self, this, true)
        val mLayout = LayoutInflater.from(context).inflate(R.layout.controls_set_indicator_self, this, true)
        val lv_selectedColorChooose = LayoutInflater.from(context).inflate(R.layout.controls_set_indicator_self, this, true).findViewById<LinearLayout>(R.id.lv_selectedColorChoose)
        val rb_normalBlack = mLayout.findViewById<RadioButton>(R.id.rb_normalBlack)
        val rb_normalRed = mLayout.findViewById<RadioButton>(R.id.rb_normalRed)
        val rb_selectedBlack = mLayout.findViewById<RadioButton>(R.id.rb_selectedBlack)
        val rb_selectedRed = mLayout.findViewById<RadioButton>(R.id.rb_selectedRed)
        val rb_mode1 = mLayout.findViewById<RadioButton>(R.id.rb_mode1)
        val rb_mode2 = mLayout.findViewById<RadioButton>(R.id.rb_mode2)
        val rg_normal = mLayout.findViewById<RadioGroup>(R.id.rg_normal)
        val rg_selected = mLayout.findViewById<RadioGroup>(R.id.rg_selected)


        rg_normal.setOnCheckedChangeListener { group, checkedId ->
            if (rb_normalBlack.isChecked){
                Log.d("SetIndicatorSelf","正常黑色被选中了")
                lv_selectedColorChooose.visibility = VISIBLE
                normalColor = "#FF000000"

            }
            if (rb_normalRed.isChecked){
                Log.d("SetIndicatorSelf","正常红色被选中了")
                lv_selectedColorChooose.visibility = VISIBLE
                normalColor = "#FF0000"
            }
        }

        rg_selected.setOnCheckedChangeListener { group, checkedId ->
            if (rb_selectedBlack.isChecked){
                Log.d("SetIndicatorSelf","选中黑色被选中了")
                selectedColor="#FF000000"
            }
            if (rb_selectedRed.isChecked){
                Log.d("SetIndicatorSelf","选中红色被选中了")
                selectedColor="#FF0000"
            }
        }

        rg_mode.setOnCheckedChangeListener { group, checkedId ->
            if (rb_mode1.isChecked){
                bt_ensureIndicator.isEnabled = true
                mode="mode1"
            }
            if (rb_mode2.isChecked){
                bt_ensureIndicator.isEnabled = true
                mode="mode2"
            }
        }

        bt_ensureIndicator.setOnClickListener {
            if (bt_ensureIndicator.isEnabled == false){
                Toast.makeText(context,"请设置完全",Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(context, ShowingPage::class.java)
                intent.putExtra("normalColor", normalColor)
                intent.putExtra("selectedColor", selectedColor)
                intent.putExtra("speed",speed)
                intent.putExtra("mode",mode)
                context.startActivity(intent)
            }

        }

        bt_defaultIndicator.setOnClickListener {
            val intent = Intent(context, ShowingPage::class.java)
            intent.putExtra("normalColor","black")
            intent.putExtra("selectedColor","red")
            intent.putExtra("speed",speed)
            intent.putExtra("mode", "mode1")
            context.startActivity(intent)
        }

    }


}