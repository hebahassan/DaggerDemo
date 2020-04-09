package com.example.daggermvvm.di

import androidx.lifecycle.ViewModelProvider
import com.example.daggermvvm.app.ViewModelProviderFactory
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelProviderFactory(viewModelProviderFactory: ViewModelProviderFactory): ViewModelProvider.Factory
}