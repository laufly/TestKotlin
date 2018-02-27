package com.wilddog.testkotlin.activity

import android.content.Context
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
        // 不用使用findViewById ,直接用id
        btn_recycler_view.setOnClickListener{
            showToast("a : "+a)
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
        btn_animator.setOnClickListener{
            gotoAnimatorActivity()
        }

    }

    // kotlin 扩展功能
    fun Context.showMessage(msg: String){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }

    fun showToast(msg: String){
        this.showMessage(msg)
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

    fun gotoAnimatorActivity(){
        var intent = Intent(this, AnimatorActivity::class.java)
        startActivity(intent)
        finish()
    }
}
