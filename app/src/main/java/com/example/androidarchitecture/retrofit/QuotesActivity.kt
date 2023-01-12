package com.example.androidarchitecture.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.androidarchitecture.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class QuotesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
        val quotesAPI=RetrofitHelper.getInstance().create(QuotesAPI::class.java)
        GlobalScope.launch {
       var result=     quotesAPI.getQuotes(1);
            if(result!=null){
                Log.d("TAG", "onCreate: COTELIST"+result.body().toString())
            }
            var quoteList=result.body()
            if(quoteList!=null){
                quoteList.results.forEach{
                    Log.d("TAG", "onCreate: "+it.content)
                }
            }

        }
    }
}