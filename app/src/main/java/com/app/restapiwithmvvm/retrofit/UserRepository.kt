package com.app.restapiwithmvvm.retrofit

import android.content.Context
import com.app.restapiwithmvvm.model.AppDatabase
import com.app.restapiwithmvvm.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class UserRepository(private val context: Context) {

    private val apiService = RetrofitClient.getInstance().create(ApiService::class.java)
    private val db = AppDatabase.getDatabase(context)

    fun getUsers(): Flow<List<User>> = flow {
        //val usersLiveData = MutableLiveData<List<User>>()
        val dbUser = db.userDao().getAllUsers()
        if (dbUser.size > 0) {
            emit(dbUser)
        } else {
            val response = try {
                apiService.getUsers().execute() // Synchronous call
            } catch (e: Exception) {
                null
            }
            if (response != null && response.isSuccessful) {
                val users = response.body() ?: emptyList()
                db.userDao().insertAll(users) // Save to DB
                emit(users)
            } else {
                emit(emptyList()) // API failure
            }
        }
    }.flowOn(Dispatchers.IO)
}