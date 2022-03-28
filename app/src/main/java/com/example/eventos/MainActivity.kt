package com.example.eventos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.eventos.features.eventsList.presentation.EventsListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
    }
}