package com.app.restapiwithmvvm.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.restapiwithmvvm.model.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertAll(users: List<User>)

    @Query("SELECT * FROM users1")
    fun getAllUsers(): List<User>
}