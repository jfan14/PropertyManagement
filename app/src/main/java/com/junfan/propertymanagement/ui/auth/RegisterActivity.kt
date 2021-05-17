package com.junfan.propertymanagement.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.junfan.propertymanagement.R
import com.junfan.propertymanagement.databinding.ActivityRegisterBinding
import com.junfan.propertymanagement.data.model.User
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.view.*

class RegisterActivity : AppCompatActivity(), AuthListener {

    lateinit var mDataBinding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_register)
        var viewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        mDataBinding.userInfo = viewModel
        viewModel.authListener = this

        landlord_email_edit_layout.visibility = View.GONE
        init()
    }

    private fun init() {
        text_view_tologin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
        radio_button_tenent.setOnClickListener {
            Toast.makeText(applicationContext, "here", Toast.LENGTH_SHORT).show()
            landlord_email_edit_layout.visibility = View.VISIBLE
        }
    }


    override fun onSuccess(authResponse: LiveData<User>) {
        authResponse.observe(this, Observer{
            Toast.makeText(applicationContext, "Success", Toast.LENGTH_SHORT).show()
        })
    }

    override fun onFailure(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}