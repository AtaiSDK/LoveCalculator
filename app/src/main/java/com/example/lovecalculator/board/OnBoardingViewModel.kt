package com.example.lovecalculator.board

import androidx.lifecycle.ViewModel
import com.example.lovecalculator.Pref
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(private val pref: Pref) : ViewModel() {

    fun isFirstTimeLaunch(): Boolean {
        return pref.isFirstTimeLaunch()
    }

    fun setOnBoardingFinished() {
        pref.saveSeen()
    }
}