package com.example.daggermvvm.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.daggermvvm.models.UserModel
import com.example.daggermvvm.repository.DataRepository
import com.example.daggermvvm.util.Failure
import com.example.daggermvvm.util.Loading
import com.example.daggermvvm.util.Success
import com.example.daggermvvm.util.ViewModelStatus
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class AuthViewModel @Inject constructor(
    private val dataRepository: DataRepository,
    private val disposable: CompositeDisposable
) : ViewModel() {

    val isAuthenticated = MutableLiveData<Boolean>()

    init {
        checkUserSession()
    }

    private val _userInfoStatus = MutableLiveData<ViewModelStatus<UserModel>>()
    val userInfoStatus: LiveData<ViewModelStatus<UserModel>> get() = _userInfoStatus

    private fun getLoggedInSession() = dataRepository.getLoggedInSession()

    private fun checkUserSession() {
        isAuthenticated.value = getLoggedInSession()
    }

    fun getUserInfo(userId: Int) {
        disposable.add(dataRepository.getUserInfo(userId)
            .doOnSubscribe { _userInfoStatus.value = Loading() }
            .subscribe({
                dataRepository.saveLoggedInSession(true)
                dataRepository.saveUserInfo(it)
                isAuthenticated.value = true
                _userInfoStatus.value = Success(it)
            }, {
                _userInfoStatus.value = Failure(it)
            })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}