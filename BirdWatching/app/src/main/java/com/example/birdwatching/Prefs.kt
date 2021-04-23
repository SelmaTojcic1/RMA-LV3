package com.example.birdwatching

import android.content.Context
import android.content.SharedPreferences

class Prefs(context: Context) {
    val PREFS_FILENAME = "com.example.birdwatching.prefs"
    val BACKGROUND_COLOR = "background_color"
    val BIRD_NUMBER = "bird_number"

    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_FILENAME, 0);

    var backgroundColor: Int
        get() = prefs.getInt(BACKGROUND_COLOR, Color.GREY.hex)
        set(value) = prefs.edit().putInt(BACKGROUND_COLOR, value).apply()

    var birdNumber: Int
        get() = prefs.getInt(BIRD_NUMBER, 0)
        set(value) = prefs.edit().putInt(BIRD_NUMBER, value).apply()
}