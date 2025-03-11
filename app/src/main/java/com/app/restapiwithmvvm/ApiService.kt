package com.app.restapiwithmvvm

import retrofit2.Call
import retrofit2.http.GET


interface ApiService {
    @GET("users")
    fun getUsers(): Call<List<User?>> // Ensure type consistency
}
