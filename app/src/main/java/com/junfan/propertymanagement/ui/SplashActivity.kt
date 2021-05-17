package com.junfan.propertymanagement.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.junfan.propertymanagement.ui.auth.LoginRegisterActivity
import com.junfan.propertymanagement.R

class SplashActivity : AppCompatActivity() {

    private val SPLASH_TIME = 3000L


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler().postDelayed({
            var intent = Intent(this, LoginRegisterActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_TIME)
    }
}