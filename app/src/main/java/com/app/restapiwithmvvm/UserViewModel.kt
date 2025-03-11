package com.app.restapiwithmvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel


class UserViewModel : ViewModel() {
    private val userRepository = UserRepository()
    val users: LiveData<List<User?>?> = userRepository.getUsers()
}
