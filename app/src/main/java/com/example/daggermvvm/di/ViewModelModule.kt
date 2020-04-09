package com.example.daggermvvm.di

import androidx.lifecycle.ViewModel
import com.example.daggermvvm.di.ViewModelKey
import com.example.daggermvvm.ui.auth.AuthViewModel
import com.example.daggermvvm.ui.main.MainViewModel
import com.example.daggermvvm.ui.main.posts.PostsViewModel
import com.example.daggermvvm.ui.main.profile.ProfileViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class AuthViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    abstract fun bindAuthViewModel(viewModel: AuthViewModel): ViewModel
}

@Module
abstract class MainViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun binMainViewModel(viewModel: MainViewModel): ViewModel
}

@Module
abstract class ProfileViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    abstract fun bindProfileViewModel(viewModel: ProfileViewModel): ViewModel
}

@Module
abstract class PostsViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(PostsViewModel::class)
    abstract fun bindPostsViewModel(viewModel: PostsViewModel): ViewModel
}