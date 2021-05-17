package com.junfan.propertymanagement.ui.auth

import android.content.Context
import android.transition.Visibility
import android.util.Log
import android.view.View
import android.view.View.GONE
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.junfan.propertymanagement.data.repositories.AuthRepository
import com.junfan.propertymanagement.data.model.User
import kotlinx.android.synthetic.main.activity_register.view.*

class AuthViewModel: ViewModel() {

    var email: String? = null
    var name: String? = null
    var password: String? = null
    var type: String? = null
    var landlordEmail: String? = null

    var authListener: AuthListener? = null

    fun onLoginButtonClick(view: View) {
        Log.d("ABC", "Inside AuthViewModel: onLoginButtonClicked")
        if(email.isNullOrEmpty() || password.isNullOrEmpty()) {
            authListener?.onFailure("Login Failed")
            return
        }

        var loginResponse = AuthRepository().userLogin(email!!, password!!)
        Log.d("ABC", "${loginResponse.value}")
        authListener?.onSuccess(loginResponse)
    }

    fun onRegisterButtonClick(view: View) {
        Log.d("ABC", "Inside AuthViewModel: onRegisterButtonClicked")
        if(email.isNullOrEmpty() || password.isNullOrEmpty() || name.isNullOrEmpty() || type.isNullOrEmpty()) {
            authListener?.onFailure("Please fill all blank box")
            return
        }
        var registerResponse = AuthRepository().userRegister(email!!, name!!, password!!, type!!)
        authListener?.onSuccess(registerResponse)
    }

    fun onLandlordButtonClick(view: View) {
        type = "Landlord"
    }

    fun onTenentButtonClick(view: View) {
        Toast.makeText(view.context, "Here in button clicked", Toast.LENGTH_SHORT).show()
        type = "Tenent"

    }

}