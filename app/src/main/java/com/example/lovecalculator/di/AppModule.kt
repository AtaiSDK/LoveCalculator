package com.example.lovecalculator.di

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.example.lovecalculator.Helper
import com.example.lovecalculator.Pref
import com.example.lovecalculator.board.OnBoardingViewModel
import com.example.lovecalculator.remote.LoveApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {
    @Provides
    fun provideApi() : LoveApi{
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build().create(LoveApi::class.java)
    }

    @Provides
    fun provideHelper() : Helper {
        return Helper()
    }

    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }

    @Provides
    fun providePref(@ApplicationContext context: Context): Pref {
        return Pref(context)
    }

    @Provides
    fun provideOnBoardingViewModel(pref: Pref): OnBoardingViewModel {
        return OnBoardingViewModel(pref)
    }
}