package com.wilddog.testkotlin.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.wilddog.testkotlin.aidl.ITestService

/**
 * Created by fly on 18-2-25.
 */
class TestService : Service(){
    override fun onBind(intent: Intent?): IBinder {
       return object : ITestService.Stub() {
           override fun basicTypes(anInt: Int, aLong: Long, aBoolean: Boolean, aFloat: Float, aDouble: Double, aString: String?) {
           }

           override fun getInterfaceName(): String {
                return "TestService"
            }
        }
    }
}