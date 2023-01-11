package com.example.androidarchitecture.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LiveDataViewModel:ViewModel() {
    val factsLiveData : LiveData<String>
    get()=factsLiveDataObject

    fun updateLiveData() {
        TODO("Not yet implemented")
    }

   private val factsLiveDataObject=MutableLiveData<String>("this is fact");
}