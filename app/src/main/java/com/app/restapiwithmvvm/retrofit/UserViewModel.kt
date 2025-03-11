package com.app.restapiwithmvvm.retrofit

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.app.restapiwithmvvm.model.User


class UserViewModel : ViewModel() {
    private val userRepository = UserRepository()
    val users: LiveData<List<User?>?> = userRepository.getUsers()
}
