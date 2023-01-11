package com.example.androidarchitecture

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity2 : AppCompatActivity() {
    lateinit var mainViewModel: QuotesViewModel
    private  val quoteText:TextView
    get()=findViewById(R.id.quoteText)
    private  val quoteAuthorText:TextView
        get()=findViewById(R.id.quoteAuthor)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quotesapp)
        mainViewModel=ViewModelProvider(this,QutoesViewModelFactory(application)).get(QuotesViewModel::class.java)
 setQuote(mainViewModel.getQuote())
    }

    fun  setQuote(quote:Quote){
        quoteText.text=quote.text
        quoteAuthorText.text=quote.author
    }

    fun onPrevious(view: View) {
      setQuote(mainViewModel.previousQuote())
    }
    fun onNext(view: View) {
        setQuote(mainViewModel.nextQuote())
    }
    fun onShare(view: View) {
        val intent=Intent(Intent.ACTION_SEND)
        intent.setType("text/plain")
        intent.putExtra(Intent.EXTRA_TEXT,mainViewModel.getQuote().text)
        startActivity(intent)


    }
}