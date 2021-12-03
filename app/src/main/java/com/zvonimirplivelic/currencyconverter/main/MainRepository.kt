package com.zvonimirplivelic.currencyconverter.main

import com.zvonimirplivelic.currencyconverter.data.models.CurrencyResponse
import com.zvonimirplivelic.currencyconverter.util.Resource

interface MainRepository {
    suspend fun getRates(base: String): Resource<CurrencyResponse>
}