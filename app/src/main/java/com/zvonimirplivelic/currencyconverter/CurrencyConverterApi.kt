package com.zvonimirplivelic.currencyconverter

import com.zvonimirplivelic.currencyconverter.data.models.CurrencyResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyConverterApi {
    @GET("/v1/latest?access_key=6a064bbb6a94b8e56b93005be626962f&format=1")
    suspend fun getRates(
        @Query("base") base: String
    ): Response<CurrencyResponse>
}