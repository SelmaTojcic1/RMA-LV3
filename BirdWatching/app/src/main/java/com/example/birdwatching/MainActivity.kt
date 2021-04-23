package com.example.birdwatching

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    var prefs: Prefs? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        prefs = Prefs(this)
        val backgroundColor = prefs!!.backgroundColor
        val birdNumber = prefs!!.birdNumber

        setContentView(R.layout.activity_main)
    }
}