package com.example.daggermvvm.di.main

import com.example.daggermvvm.di.PostsViewModelModule
import com.example.daggermvvm.di.ProfileViewModelModule
import com.example.daggermvvm.ui.main.posts.PostsFragment
import com.example.daggermvvm.ui.main.profile.ProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBuilderModule {

    @ContributesAndroidInjector(modules = [ProfileViewModelModule::class])
    abstract fun contributeProfileFragment(): ProfileFragment

    @ContributesAndroidInjector(modules = [PostsViewModelModule::class])
    abstract fun contributePostsFragment(): PostsFragment
}