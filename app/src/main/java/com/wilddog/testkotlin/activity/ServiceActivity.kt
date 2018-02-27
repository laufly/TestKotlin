package com.wilddog.testkotlin.activity

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.wilddog.testkotlin.R
import com.wilddog.testkotlin.aidl.ITestService
import com.wilddog.testkotlin.services.TestService
import kotlinx.android.synthetic.main.activity_service.*

class ServiceActivity : AppCompatActivity() {
    var service: ITestService?=null
    var con = object: ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            this@ServiceActivity.service = ITestService.Stub.asInterface(service)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)
        var intent = Intent(this@ServiceActivity,TestService::class.java)
        bindService(intent,con , Context.BIND_AUTO_CREATE)
        btn_show.setOnClickListener{
            var content = service!!.interfaceName
            Toast.makeText(this@ServiceActivity,content,Toast.LENGTH_SHORT).show()
        }
    }
}
