package com.example.myapplication.data.api

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("svc/topstories/v2/world.json?api-key=${API_TOKEN}")
    fun getInfo(): Call<NewsDto>
}

const val API_TOKEN = "QDDSJQrYEsmEqF76ILV5wGDFcXAZNCaZ"