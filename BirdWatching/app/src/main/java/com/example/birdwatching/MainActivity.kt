package com.example.birdwatching

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var birdCounter: Int = 0
    var backgroundColor: Int = R.color.white

    private val BIRD_COUNT_KEY = "count"
    private val BACKGROUND_COLOR_KEY = "color"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState != null) {
            birdCounter = savedInstanceState.getInt(BIRD_COUNT_KEY)
            if(birdCounter != 0 ) {
                tv_bird_count.text = birdCounter.toString()
            }
            backgroundColor = savedInstanceState.getInt(BACKGROUND_COLOR_KEY)
            tv_bird_count.setBackgroundResource(backgroundColor)
        }

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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt(BIRD_COUNT_KEY, birdCounter)
        outState.putInt(BACKGROUND_COLOR_KEY, backgroundColor)
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
}