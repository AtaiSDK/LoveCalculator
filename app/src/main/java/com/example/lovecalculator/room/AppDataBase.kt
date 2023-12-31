package com.example.lovecalculator.room

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.lovecalculator.remote.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun loveDao(): LoveDao
}