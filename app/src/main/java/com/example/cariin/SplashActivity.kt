package com.example.cariin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    private val SPLASH_DELAY: Long = 2000 // Delay in milliseconds (2 seconds)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Use a Handler to delay the navigation to the main activity
        Handler().postDelayed({
            // Start the main activity
            val intent = Intent(this, StartAppActivity::class.java)
            startActivity(intent)

            // Finish the splash activity to remove it from the back stack
            finish()
        }, SPLASH_DELAY)
    }
}