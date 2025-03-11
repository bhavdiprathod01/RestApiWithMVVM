package com.app.restapiwithmvvm.retrofit

import com.app.restapiwithmvvm.model.User
import retrofit2.Call
import retrofit2.http.GET


interface ApiService {
    @GET("users")
    fun getUsers(): Call<List<User?>> // Ensure type consistency
}
