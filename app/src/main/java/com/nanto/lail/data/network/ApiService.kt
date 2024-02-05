package com.nanto.lail.data.network

import com.nanto.lail.data.response.ResponseDzikir
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("f9226f61608710af89dc")
    fun getDzikirPagi(): Call<ResponseDzikir>

    @GET("2f8374c83f0eb3efdffd")
    fun getDzikirPetang(): Call<ResponseDzikir>
}