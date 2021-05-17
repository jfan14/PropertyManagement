package com.junfan.propertymanagement.data.repositories

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.junfan.propertymanagement.data.network.MyApi
import com.junfan.propertymanagement.data.model.LoginResponse
import com.junfan.propertymanagement.data.model.RegisterResponse
import com.junfan.propertymanagement.data.model.User
import com.junfan.propertymanagement.ui.auth.RegisterActivity
import kotlinx.android.synthetic.main.activity_register.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthRepository {

    fun userLogin(email: String, password: String): LiveData<User> {

        var loginResponse = MutableLiveData<User>()

        var api = MyApi()
        api.userLogin(email, password)
            .enqueue(object: Callback<User>{
                override fun onResponse(
                    call: Call<User>,
                    response: Response<User>
                ) {
                    if(response.isSuccessful)
                        loginResponse.value = User(email=email, password=password)
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    t.printStackTrace()
                    Log.d("abc", "Login Failed")
                }

            })
        return loginResponse
    }

    fun userRegister(email: String, password: String, name: String, type: String): LiveData<User> {

        var registerResponse = MutableLiveData<User>()

        var api = MyApi()
        api.userRegister(email, password, name, type)
            .enqueue(object : Callback<User> {
                override fun onFailure(call: Call<User>, t: Throwable) {
                    Log.d("abc", "Register Failed")
                }

                override fun onResponse(call: Call<User>, response: Response<User>) {
                    if(response.isSuccessful) {
                        registerResponse.value = User(email=email, name=name, password = password, type="tenant")
                        Log.d("abcd", "Register Success")
                    }
                }

            })
        return registerResponse
    }



}
