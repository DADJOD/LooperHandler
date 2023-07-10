package com.example.looperhandler

import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log

internal class MyThread : Thread() {
    lateinit var handler: MyHandler

    override fun run() {
        Looper.prepare()
        handler = MyHandler()
        Looper.loop()
    }
}

internal class MyHandler : Handler() {

    override fun handleMessage(msg: Message) {
        Log.d("happySDK", "${System.currentTimeMillis()}")
    }
}
