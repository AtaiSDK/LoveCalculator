package com.example.lovecalculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.lovecalculator.remote.LoveModel

class LoveViewModel : ViewModel(){
    var repository =  Repository()

    fun getLiveData(firstName : String, secondName : String):LiveData<LoveModel>{
        return repository.getPercentage(firstName, secondName)
    }
}