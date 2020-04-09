package com.example.daggermvvm.util

open class ViewModelStatus<T>

data class Loading<T>(val data: T? = null) : ViewModelStatus<T>()

data class Success<T>(val data: T) : ViewModelStatus<T>()

data class Failure<T>(val error: Throwable, val data: T? = null) : ViewModelStatus<T>()