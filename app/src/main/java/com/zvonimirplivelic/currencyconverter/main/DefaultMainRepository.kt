package com.zvonimirplivelic.currencyconverter.main

import com.zvonimirplivelic.currencyconverter.CurrencyConverterApi
import com.zvonimirplivelic.currencyconverter.data.models.CurrencyResponse
import com.zvonimirplivelic.currencyconverter.util.Resource
import javax.inject.Inject

class DefaultMainRepository @Inject constructor(
    private val api: CurrencyConverterApi
) : MainRepository {

    override suspend fun getRates(base: String): Resource<CurrencyResponse> {
        return try {
            val response = api.getRates(base)
            val result = response.body()
            if (response.isSuccessful && result != null) {
                Resource.Success(result)
            } else {
                Resource.Error(response.message())
            }
        } catch (e: Exception) {
            Resource.Error(e.message)
        }
    }
}