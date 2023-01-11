package com.example.androidarchitecture.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.androidarchitecture.R

class LiveDataActivity : AppCompatActivity() {
    lateinit var mainViewModel: LiveDataViewModel
    private  val  factsTextView: TextView
        get( )=findViewById(R.id.textView)

    private  val  btnUpdate: Button
        get( )=findViewById(R.id.button2)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)
        mainViewModel=ViewModelProvider(this).get(LiveDataViewModel::class.java)
        mainViewModel.factsLiveData.observe(this, Observer {
factsTextView.text=it
            btnUpdate.setOnClickListener{
                mainViewModel.updateLiveData()
            }
        })

    }
}