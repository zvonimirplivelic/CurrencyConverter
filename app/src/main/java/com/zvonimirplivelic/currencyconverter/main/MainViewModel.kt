package com.zvonimirplivelic.currencyconverter.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.zvonimirplivelic.currencyconverter.util.DispatcherProvider

class MainViewModel @ViewModelInject constructor(
    private val repository: MainRepository,
    private val dispatchers: DispatcherProvider
): ViewModel() {

    
}