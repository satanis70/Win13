package com.example.win13

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val context = this

        object : CountDownTimer(3000, 1000) {
            override fun onTick(p0: Long) {}
            override fun onFinish() {
                startActivity(Intent(context, MainActivity::class.java))
                finish()
            }
        }.start()
    }
}