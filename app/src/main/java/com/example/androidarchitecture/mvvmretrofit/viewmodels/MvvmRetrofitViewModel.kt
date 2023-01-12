package com.example.androidarchitecture.mvvmretrofit.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidarchitecture.mvvmretrofit.models.QuoteList
import com.example.androidarchitecture.mvvmretrofit.repository.QuotesRepository
import com.example.androidarchitecture.mvvmretrofit.repository.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MvvmRetrofitViewModel(private val repository: QuotesRepository) : ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getQuotes(1)
        }
    }

    val quotes: LiveData<Response<QuoteList>>
        get() = repository.quotes

}