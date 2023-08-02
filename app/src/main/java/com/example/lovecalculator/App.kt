package com.example.lovecalculator

import android.app.Application
import android.content.SharedPreferences
import androidx.room.Room
import com.example.lovecalculator.room.AppDataBase
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class App: Application() {

    companion object{
        lateinit var appDataBase: AppDataBase
    }

    override fun onCreate() {
        super.onCreate()
        appDataBase = Room.databaseBuilder(applicationContext, AppDataBase::class.java, "love-file")
            .allowMainThreadQueries()
            .build()
    }
}

