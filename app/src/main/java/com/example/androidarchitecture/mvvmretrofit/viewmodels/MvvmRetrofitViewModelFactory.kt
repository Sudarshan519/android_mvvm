package com.example.androidarchitecture.mvvmretrofit.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidarchitecture.mvvmretrofit.repository.QuotesRepository

class MvvmRetrofitViewModelFactory(private val repository: QuotesRepository) :ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MvvmRetrofitViewModel(repository) as T
    }
}