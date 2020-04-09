package com.example.daggermvvm.models

import com.google.gson.annotations.SerializedName

data class UserPosts(
    @SerializedName("body")
    val body: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("userId")
    val userId: Int
)