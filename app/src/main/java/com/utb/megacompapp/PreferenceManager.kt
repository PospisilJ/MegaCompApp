package com.utb.megacompapp

import android.content.Context
import android.content.SharedPreferences

class PreferenceManager private constructor(context: Context) {

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    var heartCount: Int
        get() = sharedPreferences.getInt(KEY_HEART_COUNT, 0)
        set(value) = sharedPreferences.edit().putInt(KEY_HEART_COUNT, value).apply()

    companion object {
        private const val PREF_NAME = "MyPreferences"
        private const val KEY_HEART_COUNT = "heartCount"

        private var instance: PreferenceManager? = null

        fun getInstance(context: Context): PreferenceManager {
            if (instance == null) {
                instance = PreferenceManager(context)
            }
            return instance!!
        }

    }
}