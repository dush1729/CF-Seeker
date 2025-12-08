package com.example.cfseeker.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.cfseeker.data.local.entity.RatingChangeEntity
import com.example.cfseeker.data.local.entity.UserEntity
import com.example.cfseeker.data.local.entity.UserRatingChanges
import com.example.cfseeker.databinding.UserItemBinding

class UserAdapter: ListAdapter<UserRatingChanges, UserAdapter.UserViewHolder>(
    UserRatingChangeDiffUtil()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = UserItemBinding.inflate(inflater, parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class UserViewHolder(private val binding: UserItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(userRatingChange: UserRatingChanges) {
            binding.userAvatar.load(userRatingChange.user.avatar)
            binding.userHandle.text = userRatingChange.user.handle
            userRatingChange.ratingChanges.lastOrNull()?.let { userRatingChange ->
                val delta = userRatingChange.newRating - userRatingChange.oldRating
                binding.ratingDelta.text = delta.toString()
                if(delta < 0) {
                    binding.ratingDelta.setTextColor(binding.root.context.getColor(android.R.color.holo_red_dark))
                }
                binding.newRating.text = userRatingChange.newRating.toString()
            }
        }
    }
}

private class UserRatingChangeDiffUtil:
    DiffUtil.ItemCallback<UserRatingChanges>() {
    override fun areItemsTheSame(oldItem: UserRatingChanges, newItem: UserRatingChanges): Boolean {
        return oldItem.user.handle == newItem.user.handle
    }

    override fun areContentsTheSame(oldItem: UserRatingChanges, newItem: UserRatingChanges): Boolean {
        return oldItem == newItem
    }
}