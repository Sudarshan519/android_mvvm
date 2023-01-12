package com.example.androidarchitecture.listadapters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidarchitecture.R

class ListAdapterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_adapter)
        val recyclerView=findViewById<RecyclerView  >(R.id.programming_list)
        val adapter=ProgrammingAdapter()

        var p1=ProgrammingItem(1,"P","Programming Item")
        var p2=ProgrammingItem(2,"P","Programming Item")
        var p3=ProgrammingItem(3,"P","Programming Item")
        adapter.submitList(listOf(p1,p2,p3))
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter=adapter
        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            var p3=ProgrammingItem(3,"P","Programming Item")
            var p4=ProgrammingItem(1,"4","Programming Item")
            var p5=ProgrammingItem(2,"5","Programming Item")
            var p6=ProgrammingItem(3,"6","Programming Item")
            adapter.submitList(listOf(p3,p4,p5,p6))
        },4000)

    }
}