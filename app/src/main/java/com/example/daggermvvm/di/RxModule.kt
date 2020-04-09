package com.example.daggermvvm.di

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class RxModule {

    companion object {

        @Provides
        fun provideDisposable() = CompositeDisposable()
    }
}