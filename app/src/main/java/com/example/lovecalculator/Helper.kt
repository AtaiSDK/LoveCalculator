package com.example.lovecalculator

import android.content.Context
import android.widget.Toast
import javax.inject.Inject

class Helper @Inject constructor() {
    fun showToast(context: Context,  msg: String){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }
}