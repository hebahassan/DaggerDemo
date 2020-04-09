package com.example.daggermvvm.ui.main

import androidx.lifecycle.ViewModel
import com.example.daggermvvm.repository.DataRepository
import javax.inject.Inject

class MainViewModel @Inject constructor(private val dataRepository: DataRepository) : ViewModel() {

    private fun deleteUser() {
        dataRepository.deleteUserInfo()
        dataRepository.saveLoggedInSession(false)
    }

    fun logout() {
        deleteUser()
    }
}