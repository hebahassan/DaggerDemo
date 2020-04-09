package com.example.daggermvvm.di

import android.app.Application
import com.example.daggermvvm.app.BaseApplication
import com.example.daggermvvm.helper.DataHelper
import com.example.daggermvvm.repository.DataRepository
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuilderModule::class,
        AppModule::class,
        ViewModelFactoryModule::class,
        RxModule::class]
)
interface AppComponent : AndroidInjector<BaseApplication> {

    fun prefHelper(): DataHelper

    fun dataRepository(): DataRepository

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}