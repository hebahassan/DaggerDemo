package com.example.daggermvvm.helper

import com.example.daggermvvm.models.UserModel

interface IPrefHelper {

    fun saveUserInfo(userModel: UserModel)

    fun getUserInfo(): UserModel

    fun deleteUserInfo()

    fun saveLoggedInSession(isLoggedIn: Boolean)

    fun getLoggedInSession(): Boolean
}