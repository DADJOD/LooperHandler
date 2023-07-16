package com.example.looperhandler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.os.Messenger
import android.os.RemoteException
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity() {
    private val myThread = MyThread()
    private val myMainHandler = MyMainHandler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val message = myMainHandler.obtainMessage()

        message.arg1 = 11
        message.arg2 = 22
        message.obj = Object()

        myMainHandler.dispatchMessage(message)

        val messenger = Messenger(myMainHandler)
        val i = Intent()

//        i.putExtra("MYHANDLER", myMainHandler)  // не работает потому что myMainHandler не implement'ит serializable и parcelable
        i.putExtra("MYMESSENGER", messenger)

//        val m = Message()
//        try {
//            messenger.send(m)
//        } catch (e: RemoteException) {
//            e.printStackTrace()
//        }

        myThread.start()
    }

    fun postMessage(view: View) {
        val message = myThread.handler.obtainMessage()
        myThread.handler.dispatchMessage(message)
    }
}

class MyMainHandler : Handler() {
    override fun handleMessage(msg: Message) {
        Log.d("happySDK", "Main : ${System.currentTimeMillis()}")

        if (msg.arg2 == 55) {
            TODO()
        }
    }
}