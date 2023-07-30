package com.example.lovecalculator

import android.content.Context

class Pref(private val context: Context) {

    private val pref by lazy {
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }
    fun saveSeen(){
        pref.edit().putBoolean(SEEN_KEY, true).apply()
    }

    fun isFirstTimeLaunch(): Boolean {
        return pref.getBoolean(SEEN_KEY, true)
    }

    companion object {
        const val PREF_NAME = "task.pref"
        const val SEEN_KEY = "user_key"
    }

}