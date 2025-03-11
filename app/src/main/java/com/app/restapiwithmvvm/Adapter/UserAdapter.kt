package com.app.restapiwithmvvm.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.restapiwithmvvm.model.User

class UserAdapter : RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    private var userList: List<User?>? = null

    fun setUserList(userList: List<User?>?) {
        this.userList = userList
        notifyDataSetChanged()  // Refresh RecyclerView when data updates
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(android.R.layout.simple_list_item_2, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = userList?.get(position)
        holder.text1.text = user?.name ?: "No Name"
        holder.text2.text = user?.email +" \n"+user?.phone ?: "No Email"
    }

    override fun getItemCount(): Int {
        return userList?.size ?: 0
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text1: TextView = itemView.findViewById(android.R.id.text1)
        val text2: TextView = itemView.findViewById(android.R.id.text2)
    }
}
