package com.app.restapiwithmvvm

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.restapiwithmvvm.Adapter.UserAdapter
import com.app.restapiwithmvvm.retrofit.UserViewModel

class MainActivity : AppCompatActivity() {
    private var recyclerView: RecyclerView? = null
    private var userAdapter: UserAdapter? = null
    private var userViewModel: UserViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView?.layoutManager = LinearLayoutManager(this)
        userAdapter = UserAdapter()
        recyclerView?.adapter = userAdapter

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        userViewModel?.getUsersData()
        userViewModel?.users?.observe(this) { users ->
            if (!users.isNullOrEmpty()) {
                userAdapter?.setUserList(users)
                Log.e("size", users.size.toString())
            } else {
                Toast.makeText(applicationContext,"no data found",Toast.LENGTH_LONG).show();
            }
        }


    }
}