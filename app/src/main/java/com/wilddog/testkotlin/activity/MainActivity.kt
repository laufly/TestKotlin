package com.wilddog.testkotlin.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

import com.wilddog.testkotlin.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var a: Int =5
    var b = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("a : {a}")
        btn_recycler_view.setOnClickListener{
            showMessage("a : "+a)
            gotoRecyclerViewActivity()
        }
        btn_net.setOnClickListener{
            gotoNetActivity()
        }
        btn_wilddog.setOnClickListener{
            gotoWilddogActivity()
        }
        btn_aidl.setOnClickListener{
            gotoServiceActivity()
        }

    }

    fun showMessage(msg: String){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }

    fun gotoRecyclerViewActivity(){
        var intent: Intent = Intent(this,RecyclerViewActivity::class.java)
        startActivity(intent)
        finish()
    }
    fun gotoNetActivity(){
        var intent: Intent = Intent(this,NetActivity::class.java)
        startActivity(intent)
        finish()
    }
    fun gotoWilddogActivity(){
        var intent: Intent = Intent(this,WilddogActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun gotoServiceActivity(){
        var intent: Intent = Intent(this,ServiceActivity::class.java)
        startActivity(intent)
        finish()
    }
}
