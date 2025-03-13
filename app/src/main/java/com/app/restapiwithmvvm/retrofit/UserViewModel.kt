package com.app.restapiwithmvvm.retrofit

import android.app.Activity
import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.app.restapiwithmvvm.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val userRepository = UserRepository(application)
    val users = MutableLiveData<List<User>>()
    fun getUsersData() = viewModelScope.launch(Dispatchers.Main) {
        userRepository.getUsers().collect {
            users.value = it
        }
    }

}