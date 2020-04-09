package com.example.daggermvvm.helper

import com.example.daggermvvm.models.UserModel
import com.example.daggermvvm.models.UserPosts
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IApiHelper {

    @GET("users")
    fun getUsers(): Observable<List<UserModel>>

    @GET("users/{id}")
    fun getUserDetails(@Path("id") id: Int): Observable<UserModel>

    @GET("/posts")
    fun getUserPosts(@Query("userId") userId: Int): Observable<List<UserPosts>>
}