package com.example.androidarchitecture.contact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.room.Room
import com.example.androidarchitecture.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.Date

class ContactActivity : AppCompatActivity() {
    lateinit var database: ContactDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)
//        database= Room.databaseBuilder(applicationContext,ContactDatabase::class.java,"contactDB").build()
database=ContactDatabase.getDatabase(this)
        GlobalScope.launch {
            database.contactDAO().intertContact(Contact(44,"DEF","1234",Date(),1));
        }


    }

    fun getData(view: View) {
        database.contactDAO().getContact().observe(this, Observer {
            Log.d("TAG", "getData: ${it.toString()}",)
        })
    }
}