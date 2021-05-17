package com.junfan.propertymanagement.data.model

import java.io.Serializable

data class LoginResponse(
    val token: String,
    val user: User
):Serializable

data class RegisterResponse(
    val data: User,
    val error: Boolean,
    val message: String
):Serializable

data class UserResponse(
    val count: Int,
    val data: ArrayList<User>,
    val error: Boolean
):Serializable

data class User(
    //val __v: Int? = null,
    var _id: String? = null,
    //val createdAt: String? = null,
    var email: String? = null,
    val landlordEmail: String? = null,
    var name: String? = null,
    val password: String? = null,
    val type: String? = null
):Serializable {
    constructor(id: String, name: String, email: String): this() {
        _id = id
        this.name = name
        this.email = email
    }
}