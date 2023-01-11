package com.example.androidarchitecture

import Observer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    lateinit var txtCounter:TextView
    lateinit var mainViewModel:MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycle.addObserver(Observer())
        mainViewModel=ViewModelProvider(this,MainViewModelFactory(10)).get(MainViewModel::class.java)
        txtCounter=findViewById(R.id.text)
        setText()
        Log.d("MAIN", "Activity onCreate: ")
    }


   private fun setText( ){
        txtCounter.text=mainViewModel.count.toString()
       Log.d("MAIN", "Activity UPDATE TEXT: ")
    }


    override fun onPause() {
        super.onPause()
        lifecycle.addObserver(Observer())
        Log.d("MAIN", "Activity onPause: ")
    }

    override fun onStop() {
        super.onStop()
    }

       fun  increment(v:View){
        mainViewModel.increment();
        setText()
    }

}