package com.example.daggermvvm.repository

import com.example.daggermvvm.helper.DataHelper
import com.example.daggermvvm.helper.IApiHelper
import com.example.daggermvvm.models.UserModel
import com.example.daggermvvm.models.UserPosts
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataRepository @Inject constructor(
    private val apiHelper: IApiHelper,
    private val dataHelper: DataHelper
) {

    fun getUserInfo(userId: Int): Observable<UserModel> =
        apiHelper.getUserDetails(userId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    fun getUserPosts(): Observable<List<UserPosts>> =
        apiHelper.getUserPosts(getUserSavedInfo().id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    fun saveUserInfo(userModel: UserModel) = dataHelper.saveUserInfo(userModel)

    fun getUserSavedInfo() = dataHelper.getUserInfo()

    fun deleteUserInfo() = dataHelper.deleteUserInfo()

    fun saveLoggedInSession(isLoggedIn: Boolean) = dataHelper.saveLoggedInSession(isLoggedIn)

    fun getLoggedInSession() = dataHelper.getLoggedInSession()
}