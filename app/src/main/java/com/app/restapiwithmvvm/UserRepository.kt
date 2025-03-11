package com.app.restapiwithmvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {
    private val apiService = RetrofitClient.getInstance().create(ApiService::class.java) // Fix method call

    fun getUsers(): LiveData<List<User?>?> {
        val usersLiveData = MutableLiveData<List<User?>?>()

        apiService.getUsers().enqueue(object : Callback<List<User?>> {
            override fun onResponse(call: Call<List<User?>>, response: Response<List<User?>>) {
                if (response.isSuccessful) {
                    usersLiveData.value = response.body()
                } else {
                    usersLiveData.value = null
                }
            }

            override fun onFailure(call: Call<List<User?>>, t: Throwable) {
                usersLiveData.value = null
            }
        })

        return usersLiveData
    }
}
