package com.sanyam.live.data.example

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    lateinit var tvFact: TextView
    lateinit var btnUpdate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        tvFact = findViewById(R.id.tvFact)
        btnUpdate = findViewById(R.id.btnUpdate)

        mainViewModel.factsLiveData.observe(this, Observer {
            tvFact.text = it
        })

        btnUpdate.setOnClickListener {
            mainViewModel.updateLiveData()
        }
    }
}