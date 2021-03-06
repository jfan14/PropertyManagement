package com.junfan.propertymanagement.data.model

data class PropertyResponse(
    val count: Int,
    val data: ArrayList<Data>,
    val error: Boolean
)

data class Data(
    val __v: Int,
    val _id: String,
    val address: String,
    val city: String,
    val country: String,
    val image: String,
    val latitude: String,
    val longitude: String,
    val mortageInfo: Boolean,
    val propertyStatus: Boolean,
    val purchasePrice: String,
    val state: String,
    val userId: String,
    val userType: String
)