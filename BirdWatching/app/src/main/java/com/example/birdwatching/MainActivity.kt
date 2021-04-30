package com.example.birdwatching

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var birdCounter: Int = 0
    private var backgroundColor: Int = R.color.white

    private val BIRD_COUNT_KEY = "count"
    private val BACKGROUND_COLOR_KEY = "color"
    private val PREFS_FILENAME = "com.example.birdwatching"

    private lateinit var sharedPrefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPrefs = this.getSharedPreferences(PREFS_FILENAME, Context.MODE_PRIVATE)
        birdCounter = sharedPrefs.getInt(BIRD_COUNT_KEY, 0)
        backgroundColor = sharedPrefs.getInt(BACKGROUND_COLOR_KEY, R.color.white)

        button_blue.setOnClickListener {
            countBird()
            changeBackground(R.color.blue)
        }

        button_yellow.setOnClickListener {
            countBird()
            changeBackground(R.color.yellow)
        }

        button_green.setOnClickListener {
            countBird()
            changeBackground(R.color.green)
        }

        button_red.setOnClickListener {
            countBird()
            changeBackground(R.color.red)
        }

        button_reset.setOnClickListener {
            reset()
        }
    }

    private fun countBird() {
        birdCounter++
        tv_bird_count.text = birdCounter.toString()
    }

    private fun changeBackground(color: Int) {
        backgroundColor = color
        tv_bird_count.setBackgroundResource(color)
    }

    private fun reset() {
        birdCounter = 0
        tv_bird_count.text = birdCounter.toString()

        backgroundColor = R.color.white
        tv_bird_count.setBackgroundResource(R.color.white)
    }

    override fun onStop() {
        super.onStop()
        sharedPrefs.edit().also {
            it.putInt(BIRD_COUNT_KEY, birdCounter)
            it.putInt(BACKGROUND_COLOR_KEY, backgroundColor)
        }.apply()
    }
}