package com.example.daggermvvm.ui.main.posts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.daggermvvm.R
import com.example.daggermvvm.databinding.ItemPostBinding
import com.example.daggermvvm.models.UserPosts

class PostsAdapter : RecyclerView.Adapter<PostsAdapter.PostItemView>() {

    private val postsList = ArrayList<UserPosts>()

    class PostItemView(private val binding: ItemPostBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(post: UserPosts) {
            binding.post = post
        }
    }

    fun updateList(updatedList: List<UserPosts>) {
        postsList.clear()
        postsList.addAll(updatedList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostItemView {
        val binding = DataBindingUtil.inflate<ItemPostBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_post,
            parent,
            false
        )
        return PostItemView(binding)
    }

    override fun getItemCount() = postsList.size

    override fun onBindViewHolder(holder: PostItemView, position: Int) {
        holder.bind(postsList[position])
    }
}