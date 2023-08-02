package com.example.lovecalculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lovecalculator.remote.LoveModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class LoveViewModel @Inject constructor(private val repository: Repository): ViewModel(){
    fun getLiveData(firstName : String, secondName : String):LiveData<LoveModel>{
        return repository.getPercentage(firstName, secondName)
    }
    fun getAll(): LiveData<String> {
        var result = ""
        val list = repository.getAllData()
        list.forEach{
            result +="${it.firstname} \n " +
                    "${it.secondname} \n" +
                    " ${it.percentage} \n" +
                    " ${it.result} \n\n"

        }
        return MutableLiveData(result)
    }
}