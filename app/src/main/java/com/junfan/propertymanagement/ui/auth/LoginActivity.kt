package com.junfan.propertymanagement.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.junfan.propertymanagement.R
import com.junfan.propertymanagement.databinding.ActivityLoginBinding
import com.junfan.propertymanagement.data.model.User
import com.junfan.propertymanagement.ui.HomeActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), AuthListener {

    lateinit var mDataBinding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        var viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        mDataBinding.userLoginInfo = viewModel

        viewModel.authListener = this

        init()
    }

    private fun init() {
        text_view_toregister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    override fun onSuccess(authResponse: LiveData<User>) {
        authResponse.observe(this, Observer {
            Toast.makeText(applicationContext, "Success", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, HomeActivity::class.java))
        })
    }

    override fun onFailure(message: String) {
        Log.d("abcdef", "Login Failed")
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}