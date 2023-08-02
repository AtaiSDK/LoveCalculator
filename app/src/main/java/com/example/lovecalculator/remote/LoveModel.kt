package com.example.lovecalculator.remote

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "love_table")
data class LoveModel(
    @SerializedName("fname")
    var firstname : String,
    @SerializedName("sname")
    var secondname : String,
    var percentage : String,
    var result : String,
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
): java.io.Serializable



