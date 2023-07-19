package com.example.lovecalculator

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {
    @GET("getPercentage")
    fun getPercentage(
        @Query("fname") firstName: String,
        @Query("sname") secondName: String,
        @Header("X-RapidAPI-Key") key : String = "f7dda6d8f3msh1ddf9156610516bp1bbaa0jsndf971f41428c",
        @Header("X-RapidAPI-Host") host : String = "love-calculator.p.rapidapi.com"
    ): Call<LoveModel>
}