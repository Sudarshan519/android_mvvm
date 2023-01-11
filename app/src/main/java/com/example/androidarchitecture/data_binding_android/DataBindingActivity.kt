package com.example.androidarchitecture.data_binding_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.androidarchitecture.MainViewModel
import com.example.androidarchitecture.Quote
import com.example.androidarchitecture.R
import com.example.androidarchitecture.databinding.ActivityDataBindingBinding

class DataBindingActivity : AppCompatActivity() {
    lateinit var binding:ActivityDataBindingBinding
    lateinit var mainViewModel: DataBindingViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_data_binding)
        mainViewModel=ViewModelProvider(this).get(DataBindingViewModel::class.java)
//        setContentView(R.layout.activity_data_binding)
//        binding.textView2.text="TEST AUTHOR"
//        binding.textView3.text="TEST QUOTE TEXT"
//        var quoteObj=Quote("THIS IS QUOTE","BY AUTHOR ABC")
//        binding.quote=quoteObj
//        mainViewModel.quoteLiveData.observe(this, Observer {
//            binding.textView2.text=it
//        })
        binding.mainViewModel=mainViewModel
        val post=Post("ABCD","loremskdjfklsdjflksjfk","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS6zKm2kVmL5Z547dP0ffBd5dq-CbLmor1wv5bKG_7rZA&s")
        binding.post=post
        binding.lifecycleOwner=this



    }
}