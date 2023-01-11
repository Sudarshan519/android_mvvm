package com.example.androidarchitecture

import androidx.lifecycle.ViewModel

class MainViewModel(initialValue: Int) : ViewModel() {
    var count:Int=initialValue
    public fun  increment(  ){
        count++

    }
}