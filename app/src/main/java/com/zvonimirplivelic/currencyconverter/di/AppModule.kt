package com.zvonimirplivelic.currencyconverter.di

import com.zvonimirplivelic.currencyconverter.CurrencyConverterApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.managers.ApplicationComponentManager
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

const val BASE_URL = "http://api.exchangeratesapi.io/"

@Module
@InstallIn(ApplicationComponentManager::class)
object AppModule {

    @Singleton
    @Provides
    fun provideCurrencyConverterApi() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CurrencyConverterApi::class.java)
}