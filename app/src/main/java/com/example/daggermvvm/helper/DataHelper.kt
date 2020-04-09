package com.example.daggermvvm.helper

import com.appizona.yehiahd.fastsave.FastSave
import com.example.daggermvvm.models.UserModel
import com.example.daggermvvm.util.Constants
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataHelper @Inject constructor(): IPrefHelper {

    override fun saveUserInfo(userModel: UserModel) {
        FastSave.getInstance().saveObject(Constants.PrefHelper.USER_INFO, userModel)
    }

    override fun getUserInfo(): UserModel {
        return FastSave.getInstance().getObject(Constants.PrefHelper.USER_INFO, UserModel::class.java)
    }

    override fun deleteUserInfo() {
        FastSave.getInstance().deleteValue(Constants.PrefHelper.USER_INFO)
    }

    override fun saveLoggedInSession(isLoggedIn: Boolean) {
        FastSave.getInstance().saveBoolean(Constants.PrefHelper.IS_LOGGED_IN, isLoggedIn)
    }

    override fun getLoggedInSession(): Boolean {
        return FastSave.getInstance().getBoolean(Constants.PrefHelper.IS_LOGGED_IN, false)
    }
}