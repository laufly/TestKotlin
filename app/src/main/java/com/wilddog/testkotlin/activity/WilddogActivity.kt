package com.wilddog.testkotlin.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.wilddog.client.*
import com.wilddog.testkotlin.R
import com.wilddog.wilddogcore.WilddogApp
import com.wilddog.wilddogcore.WilddogOptions
import kotlinx.android.synthetic.main.activity_wilddog.*

class WilddogActivity : AppCompatActivity() {
    var ref: SyncReference?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wilddog)
        initWilddog()
        btn_add.setOnClickListener{
            ref?.setValue("value")
        }
        btn_remove.setOnClickListener{
            ref?.removeValue()
        }
    }

    fun initWilddog(){
        var wilddogOptions = WilddogOptions.Builder().setSyncUrl("https://wd3212716810nbmfjs.wilddogio.com").build()
        WilddogApp.initializeApp(this,wilddogOptions)
        ref= WilddogSync.getInstance().getReference("/child")
        ref?.addValueEventListener(object:ValueEventListener{
            override fun onDataChange(p0: DataSnapshot?) {
                Toast.makeText(this@WilddogActivity,p0?.toString(),Toast.LENGTH_SHORT).show()
            }

            override fun onCancelled(p0: SyncError?) {
                Toast.makeText(this@WilddogActivity,p0?.message,Toast.LENGTH_SHORT).show()
            }
        })
    }

}
