package com.example.android_5.pages

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import com.example.android_5.R
import com.example.android_5.beans.DataBeans
import com.example.android_5.controls.SetImageControls

import kotlinx.android.synthetic.main.activity_set_images.*

class SetImages : AppCompatActivity() {

    companion object{
        val dataList = ArrayList<DataBeans>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_images)

        bt_chooseImage.setOnClickListener {
            val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
            intent.addCategory(Intent.CATEGORY_OPENABLE)
            intent.type = "image/*"
            startActivityForResult(intent,1)
        }

        bt_chooseImageNext.setOnClickListener {
            val intent = Intent(this,SetIndicatorSpeed::class.java)
            startActivity(intent)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            1 ->{
                if (resultCode == Activity.RESULT_OK && data!=null){
                    data.data?.let { uri ->
                        SetImages.dataList.add(DataBeans("", getBitmapFromUri(uri)))
                        Toast.makeText(this,"添加成功！", Toast.LENGTH_SHORT).show()
                        bt_chooseImage.text="继续选择"
                        bt_chooseImageNext.isEnabled = true
                    }
                }
            }
        }
        val mRecycler = findViewById<SetImageControls>(R.id.ctrl_mRecyclerView)
        mRecycler.setDataLinear(SetImages.dataList)

//        val myRecycler = findViewById<RecyclerView>(R.id.rv_test)
//        rv_test.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
//        rv_test.adapter = DataAdapter(SetImages.dataList)
    }

    private fun getBitmapFromUri(uri: Uri) = contentResolver.openFileDescriptor(uri, "r")?.use {
        BitmapFactory.decodeFileDescriptor(it.fileDescriptor)
    }
}