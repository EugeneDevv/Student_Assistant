package com.eugene.student_assistant.welcome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ProgressBar
import com.eugene.student_assistant.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val bar = findViewById<ProgressBar>(R.id.splash_progressBar)

        Handler().postDelayed({startActivity(Intent(this, LogInActivity::class.java))
        }, 2000) //7000 = 5 seconds
    }
}
