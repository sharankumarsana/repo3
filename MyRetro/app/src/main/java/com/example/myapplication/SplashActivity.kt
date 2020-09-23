package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {

    // This is the loading time of the splash screen
    private val splashTimeCount: Long = 3000 //
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        Looper.myLooper()?.let {
            Handler(it).postDelayed({
                // This method will be executed once the timer is over
                // Start your app main activity

                startActivity(Intent(this, MainActivity::class.java))

                // close this activity
                finish()
            }, splashTimeCount)
        }
    }
}