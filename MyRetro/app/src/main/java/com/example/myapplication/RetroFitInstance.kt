package com.example.myapplication

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory




class RetroFitInstance {

    private var baseurl="https://gorest.co.in/"
    fun getRetrofitInstance(): Retrofit {

        return Retrofit.Builder()
            .baseUrl(baseurl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}