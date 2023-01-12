package com.example.androidarchitecture.mvvmretrofit.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.androidarchitecture.mvvmretrofit.models.Result
@Dao
interface QuoteDAO {
    @Insert
    suspend fun addQuotes(quotes:List< Result>)
    @Query("SELECT * FROM quote")
    suspend fun getQuotes():List<Result>
}