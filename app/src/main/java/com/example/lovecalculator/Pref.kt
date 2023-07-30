package com.example.lovecalculator

import android.content.Context
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


class Pref @Inject constructor(private val context: Context) {

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