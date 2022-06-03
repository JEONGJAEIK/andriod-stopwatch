package com.example.jaeik1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var timerTask: Timer? = null
        var isRunning = false
        var sec: Int = 0
        val tv: TextView = findViewById(R.id.tv_hello)
        val btn: Button = findViewById(R.id.btn_kor)

        btn.setOnClickListener {
            isRunning = !isRunning
            if (isRunning == true) {
                timerTask = kotlin.concurrent.timer(period = 10) {
                    sec++
                    runOnUiThread {
                        tv.text = (sec.toFloat()/100).toString()
                    }
                }
            } else {
                timerTask?.cancel()
            }

        }
    }
}
