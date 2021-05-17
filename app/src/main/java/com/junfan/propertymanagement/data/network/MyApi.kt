package com.junfan.propertymanagement.data.network

import com.junfan.propertymanagement.data.model.LoginResponse
import com.junfan.propertymanagement.data.model.RegisterResponse
import com.junfan.propertymanagement.data.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MyApi {


    @FormUrlEncoded
    @POST("auth/login")
    fun userLogin(
        @Field("email")email:String,
        @Field("password")password:String
    ): Call<User>

    @FormUrlEncoded
    @POST("auth/register")
    fun userRegister(
        @Field("email")email:String,
        @Field("password")password:String,
        @Field("type")type:String,
        @Field("name")name:String
    ): Call<User>

    companion object {
        operator fun invoke(): MyApi {
            return Retrofit.Builder()
                .baseUrl("https://apolis-property-management.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }
}