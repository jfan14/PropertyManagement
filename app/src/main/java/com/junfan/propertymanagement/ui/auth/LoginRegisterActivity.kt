package com.junfan.propertymanagement.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.junfan.propertymanagement.R
import kotlinx.android.synthetic.main.activity_login_register.*

class LoginRegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_register)

        init()
    }

    private fun init() {
        button_login_loginregister.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
        button_register_loginregister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}