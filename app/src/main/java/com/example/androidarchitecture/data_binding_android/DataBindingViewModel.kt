package com.example.androidarchitecture.data_binding_android

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataBindingViewModel : ViewModel(){
    var quoteLiveData=MutableLiveData("What you give is what you get")
    fun update() {
        quoteLiveData.value = "You'll see it when you belive it."
    }
}