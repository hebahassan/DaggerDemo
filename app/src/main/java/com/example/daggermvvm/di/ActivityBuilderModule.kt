package com.example.daggermvvm.di

import com.example.daggermvvm.di.main.MainFragmentBuilderModule
import com.example.daggermvvm.di.scopes.AuthScope
import com.example.daggermvvm.di.scopes.MainScope
import com.example.daggermvvm.ui.auth.AuthActivity
import com.example.daggermvvm.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @AuthScope
    @ContributesAndroidInjector(modules = [AuthViewModelModule::class])
    abstract fun contributeAuthActivity(): AuthActivity

    @MainScope
    @ContributesAndroidInjector(modules = [MainViewModelModule::class, MainFragmentBuilderModule::class])
    abstract fun contributeMainActivity(): MainActivity
}