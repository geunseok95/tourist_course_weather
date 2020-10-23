package com.professionalandroid.apps.touristspotweather

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory


object ConnectRetrofit {
    fun retrofitService(): RetrofitService = retrofit.create(
        RetrofitService::class.java)
    // connect server
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://apis.data.go.kr/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

}