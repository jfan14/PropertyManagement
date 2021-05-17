package com.junfan.propertymanagement.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.junfan.propertymanagement.R
import com.junfan.propertymanagement.ui.auth.LoginActivity
import com.junfan.propertymanagement.ui.property.AddPropertyActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        init()
    }

    private fun init() {
        button_logout_home.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
        div_properties.setOnClickListener {
            startActivity(Intent(this, AddPropertyActivity::class.java))
        }
    }
}