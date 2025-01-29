package com.openclassrooms.magicgithub.ui.user_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.openclassrooms.magicgithub.R
import com.openclassrooms.magicgithub.databinding.ItemListUserBinding
import com.openclassrooms.magicgithub.model.User
import com.openclassrooms.magicgithub.utils.UserDiffCallback

class UserListAdapter(  // FOR CALLBACK ---
    private val callback: Listener
) : RecyclerView.Adapter<ListUserViewHolder>() {
    // FOR DATA ---
    private var users: List<User> = ArrayList()

    interface Listener {
        fun onClickDelete(user: User)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListUserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemListUserBinding.inflate(inflater, parent, false)
        return ListUserViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ListUserViewHolder, position: Int) {
        holder.bind(users[position], callback)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    //PUBLIC API ---
    fun updateList(newList: List<User>) {
        val diffResult = DiffUtil.calculateDiff(UserDiffCallback(newList, users))
        users = newList.toList()
        diffResult.dispatchUpdatesTo(this)
    }
}