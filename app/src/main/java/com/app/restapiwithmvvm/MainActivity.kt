package com.app.restapiwithmvvm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private var recyclerView: RecyclerView? = null
    private var userAdapter: UserAdapter? = null
    private var userViewModel: UserViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView?.layoutManager = LinearLayoutManager(this) // Use ?. to prevent null access
        userAdapter = UserAdapter()
        recyclerView?.adapter = userAdapter // Safe call with ?

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        userViewModel!!.users.observe(
            this
        ) { users: List<User?>? ->
            if (users != null) {
                userAdapter!!.setUserList(users)
            }
        }
    }
}
