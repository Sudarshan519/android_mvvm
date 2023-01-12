package com.example.androidarchitecture.mvvmretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.androidarchitecture.R
import com.example.androidarchitecture.mvvmretrofit.api.QuoteService
import com.example.androidarchitecture.mvvmretrofit.api.RetrofitHelper
import com.example.androidarchitecture.mvvmretrofit.repository.QuotesRepository
import com.example.androidarchitecture.mvvmretrofit.repository.Response
import com.example.androidarchitecture.mvvmretrofit.viewmodels.MvvmRetrofitViewModel
import com.example.androidarchitecture.mvvmretrofit.viewmodels.MvvmRetrofitViewModelFactory

class MvvmRetrofitActivity : AppCompatActivity() {
    lateinit var mainViewModel: MvvmRetrofitViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvm_retrofit)
//        val quoteService=RetrofitHelper.getInstance().create(QuoteService::class.java)
        val repository=(application as QuoteApplication).quoteRepository
        mainViewModel=ViewModelProvider(this,MvvmRetrofitViewModelFactory(repository)).get(MvvmRetrofitViewModel::class.java)
        mainViewModel.quotes.observe(this, Observer {
          when(it){
              is Response.Loading->{}
              is Response.Success->{
                  it.data
                      ?.let {
                      Toast.makeText(this@MvvmRetrofitActivity,it.results.size.toString(),Toast.LENGTH_SHORT).show()
                  }
              }
              is Response.Error->{
                  it.errorMessage
                      ?.let {
                          Toast.makeText(this@MvvmRetrofitActivity,it .toString(),Toast.LENGTH_SHORT).show()
                      }
              }
          }

//            Log.d("TAG", "QUOTES DATA: "+it.results.toString())
//      Toast.makeText(this@MvvmRetrofitActivity,it.results.size.toString(),Toast.LENGTH_SHORT).show()
        })

    }
}