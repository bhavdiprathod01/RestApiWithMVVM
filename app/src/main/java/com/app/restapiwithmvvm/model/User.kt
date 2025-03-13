package com.app.restapiwithmvvm.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "users1")
data class User(
    @PrimaryKey  var id1: Int,
    val id: Int = 0,
    var name: String,
    var email: String,
    var phone: String
)