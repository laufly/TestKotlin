package com.wilddog.testkotlin.activity

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v7.app.AppCompatActivity
import com.wilddog.testkotlin.R
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class NetActivity : AppCompatActivity() {

    var handler = object:Handler(){
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
            when(msg?.what){
                1-> {}
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_net)
        var thread = Thread(){
            getData()
        }
        thread.start()
    }

    fun getData(){
        var url = URL("https://www.baidu.com")
        var httpConnection = url.openConnection() as HttpURLConnection
        httpConnection.connectTimeout = 8000
        httpConnection.readTimeout = 8000
        httpConnection.requestMethod = "GET"
        httpConnection.addRequestProperty("Content-Type", "application/x-www-form-urlencoded")
        httpConnection.connect()
        var result = ""
        if(httpConnection.responseCode ==200){
        var inputStreamReader = InputStreamReader(httpConnection.inputStream)
        var bufferReader = BufferedReader(inputStreamReader)
        var inputLine: String? = null
        while (bufferReader.readLine().apply { inputLine = this }!=null){
            result+=inputLine!!+"\n"
        }
        inputStreamReader.close()
        httpConnection.disconnect()
        }
        println("result:"+result)
    }
}
