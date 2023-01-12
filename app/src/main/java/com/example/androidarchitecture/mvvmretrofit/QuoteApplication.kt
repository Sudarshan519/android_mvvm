package com.example.androidarchitecture.mvvmretrofit

import android.app.Application
import android.util.Log
import androidx.constraintlayout.widget.ConstraintSet.Constraint
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.example.androidarchitecture.mvvmretrofit.api.QuoteService
import com.example.androidarchitecture.mvvmretrofit.api.RetrofitHelper
import com.example.androidarchitecture.mvvmretrofit.db.QuoteDatabase
import com.example.androidarchitecture.mvvmretrofit.repository.QuotesRepository
import com.example.androidarchitecture.mvvmretrofit.worker.QuoteWorker
import com.example.androidarchitecture.workmanager.WorkManagerActivity
import java.util.concurrent.TimeUnit

class QuoteApplication:Application() {
    lateinit var quoteRepository:QuotesRepository
    override fun onCreate() {
        super.onCreate()
        initialize()
        setupWorker()
    }

    private fun setupWorker() {
   val constraint= Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()
        Log.d("QuoteApplication", "setupWorker: WOrker called")
        var workerRequest=PeriodicWorkRequest.Builder(QuoteWorker::class.java,30,TimeUnit.MINUTES)
            .setConstraints(constraint).build()
        WorkManager.getInstance(this).enqueue(workerRequest)
    }

    private fun initialize() {
        val quoteService= RetrofitHelper.getInstance().create(QuoteService::class.java)
        val database=QuoteDatabase.getDatabase(applicationContext)
        quoteRepository=QuotesRepository(quoteService,database,applicationContext)
    }
}