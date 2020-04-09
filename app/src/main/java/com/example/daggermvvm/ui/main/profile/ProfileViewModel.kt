package com.example.daggermvvm.ui.main.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.daggermvvm.repository.DataRepository
import javax.inject.Inject

class ProfileViewModel @Inject constructor(private val dataRepository: DataRepository) :
    ViewModel() {

    val email = MutableLiveData<String>()
    val userName = MutableLiveData<String>()
    val website = MutableLiveData<String>()

    init {
        getUserData()
    }

    private fun getUserData() {
        val userModel = dataRepository.getUserSavedInfo()
        email.value = userModel.email
        userName.value = userModel.username
        website.value = userModel.website
    }
}