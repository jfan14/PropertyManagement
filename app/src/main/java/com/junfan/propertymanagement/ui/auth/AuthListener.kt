package com.junfan.propertymanagement.ui.auth

import androidx.lifecycle.LiveData
import com.junfan.propertymanagement.data.model.User

interface AuthListener {
    fun onSuccess(authResponse: LiveData<User>)
    fun onFailure(message: String)
}