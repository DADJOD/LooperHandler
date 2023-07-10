package com.example.looperhandler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    private val myThread = MyThread()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myThread.start()
    }

    fun postMessage(view: View) {
        val message = myThread.handler.obtainMessage()
        myThread.handler.dispatchMessage(message)
    }
}