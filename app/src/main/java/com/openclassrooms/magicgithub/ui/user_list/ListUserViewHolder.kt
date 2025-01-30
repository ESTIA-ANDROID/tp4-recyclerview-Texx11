package com.openclassrooms.magicgithub.ui.user_list

import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.openclassrooms.magicgithub.R
import com.openclassrooms.magicgithub.databinding.ActivityListUserBinding
import com.openclassrooms.magicgithub.databinding.ItemListUserBinding
import com.openclassrooms.magicgithub.model.User

class ListUserViewHolder(
    private val binding:ItemListUserBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(user: User, callback: UserListAdapter.Listener) {
        Glide.with(binding.root.context)
            .load(user.avatarUrl)
            .apply(RequestOptions.circleCropTransform())
            .into(binding.itemListUserAvatar)
        binding.itemListUserUsername.text = user.login
        binding.itemListUserDeleteButton.setOnClickListener{ callback.onClickDelete(user) }

        //Listener slider
        val backgroundColor = if(!user.isActive) {
            R.color.red_inactive
        }
        else {
            R.color.design_default_color_background
        }

        binding.root.setBackgroundColor(
            ContextCompat.getColor(binding.root.context, backgroundColor)
        )
    }
}