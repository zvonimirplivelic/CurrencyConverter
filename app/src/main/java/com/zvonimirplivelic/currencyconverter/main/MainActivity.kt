package com.zvonimirplivelic.currencyconverter.main

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.zvonimirplivelic.currencyconverter.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnConvert.setOnClickListener {
            viewModel.convert(
                binding.etFrom.text.toString(),
                binding.spFromCurrency.selectedItem.toString(),
                binding.spToCurrency.selectedItem.toString(),
            )
        }

        lifecycleScope.launchWhenCreated {
            when (val convertedData = viewModel.conversion.value) {
                is MainViewModel.CurrencyEvent.Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.tvConversionResult.setTextColor(Color.BLACK)
                    binding.tvConversionResult.text = convertedData.resultText
                }
                is MainViewModel.CurrencyEvent.Failure -> {
                    binding.progressBar.visibility = View.GONE
                    binding.tvConversionResult.setTextColor(Color.RED)
                    binding.tvConversionResult.text = convertedData.errorText
                }
                is MainViewModel.CurrencyEvent.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                else -> Unit
            }
        }
    }
}