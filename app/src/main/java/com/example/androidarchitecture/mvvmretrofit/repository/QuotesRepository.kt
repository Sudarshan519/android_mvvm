package com.example.androidarchitecture.mvvmretrofit.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.androidarchitecture.mvvmretrofit.api.QuoteService
import com.example.androidarchitecture.mvvmretrofit.db.QuoteDatabase
import com.example.androidarchitecture.mvvmretrofit.models.QuoteList
import com.example.androidarchitecture.mvvmretrofit.utils.NetworkUtils

class QuotesRepository(
    private val quoteService: QuoteService,
    private val quoteDatabase: QuoteDatabase,
    private val applicationContext: Context
) {
    private var quotesLiveData = MutableLiveData<Response<QuoteList>>()
    val quotes: LiveData<Response<QuoteList>>
        get() = quotesLiveData

    suspend fun getQuotes(page: Int) {
        if (NetworkUtils.isInternetAvailbale(applicationContext)) {
            try {

                val result = quoteService.getQuotes(page)
                if (result?.body() != null) {

                    quoteDatabase.quoteDao().addQuotes(result.body()!!.results)
                    quotesLiveData.postValue(Response.Success(result.body()))
                }else{
                    quotesLiveData.postValue(Response.Error("API ERROR"))
                }
            } catch (e: java.lang.Exception) {
                quotesLiveData.postValue(Response.Error(e.message.toString()))
            }
        } else {
            val quotes = quoteDatabase.quoteDao().getQuotes()
            val quoteList = QuoteList(1, 1, 1, quotes, 1, 1)
            quotesLiveData.postValue(Response.Success(quoteList))
        }
    }


    suspend fun getQuotesBackground() {
        var randomNumber = (Math.random() * 10).toInt()
        var result = quoteService.getQuotes(randomNumber)
        if (result?.body() != null) {
            quoteDatabase.quoteDao().addQuotes(result.body()!!.results)

        }


    }
}