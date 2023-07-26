package com.example.lovecalculator.remote

import com.google.gson.annotations.SerializedName


data class LoveModel(
    @SerializedName("fname")
    var firstname : String,
    @SerializedName("sname")
    var secondname : String,
    var percentage : String,
    var result : String,
): java.io.Serializable



