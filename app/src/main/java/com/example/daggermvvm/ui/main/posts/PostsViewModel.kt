package com.example.daggermvvm.ui.main.posts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.daggermvvm.models.UserPosts
import com.example.daggermvvm.repository.DataRepository
import com.example.daggermvvm.util.Failure
import com.example.daggermvvm.util.Loading
import com.example.daggermvvm.util.Success
import com.example.daggermvvm.util.ViewModelStatus
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class PostsViewModel @Inject constructor(
    private val dataRepository: DataRepository,
    private val disposable: CompositeDisposable
) : ViewModel() {

    val postsAdapter = PostsAdapter()

    private val _postsStatus = MutableLiveData<ViewModelStatus<List<UserPosts>>>()
    val postsStatus: LiveData<ViewModelStatus<List<UserPosts>>> get() = _postsStatus

    init {
        getUserPosts()
    }

    private fun getUserPosts() {
        disposable.add(dataRepository.getUserPosts()
            .doOnSubscribe { _postsStatus.value = Loading() }
            .subscribe({
                _postsStatus.value = Success(it)
                postsAdapter.updateList(it)
            }, {
                _postsStatus.value = Failure(it)
            })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}