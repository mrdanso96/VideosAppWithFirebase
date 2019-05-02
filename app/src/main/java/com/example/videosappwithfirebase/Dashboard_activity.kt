package com.example.videosappwithfirebase

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView

class Dashboard_activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard_activity)

        var lesson1 = "https://firebasestorage.googleapis.com/v0/b/videosappwithfirebase-e1bd9.appspot.com/o/3.%20Android%20App%20Development%20Digram%20part%203.mp4?alt=media&token=d18e249b-9e8c-407c-ac6f-c295534ac6b3"
        var lesson2 = "https://firebasestorage.googleapis.com/v0/b/videosappwithfirebase-e1bd9.appspot.com/o/4.%20Android%20App%20Development%20Digram%20part%204.mp4?alt=media&token=90c0b813-3e9d-4522-b089-437ea556bfdf"
        var lesson3 = "https://firebasestorage.googleapis.com/v0/b/videosappwithfirebase-e1bd9.appspot.com/o/5.%20Android%20App%20Development%20Digram%20part%205.mp4?alt=media&token=21ac55a7-8849-47c3-a3f6-16d151c1190c"
        var lesson4 = "https://firebasestorage.googleapis.com/v0/b/videosappwithfirebase-e1bd9.appspot.com/o/6.%20Android%20App%20Development%20Digram%20part%206.mp4?alt=media&token=aa8ccfa3-690d-42f9-aab2-fce40914e17e"

        var items = ArrayList<Lesson>()
        items.add(Lesson("Android Development", "Learn Android from 0 to Hero", lesson1))
        items.add(Lesson("Web Development", "Learn Android from 0 to Hero", lesson2))
        items.add(Lesson("Game Development", "Learn Android from 0 to Hero", lesson3))
        items.add(Lesson("Database Design", "Learn Android from 0 to Hero", lesson4))

        val list = findViewById<RecyclerView>(R.id.videos_list)
        val adapter = Adapter(items,applicationContext)

        list.layoutManager = GridLayoutManager(applicationContext,1)
        list.adapter = adapter


    }
}
