package com.siri.multiscreenb2cappwithintegreirteapi.ui.screens.main.product

import android.app.Application
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.siri.multiscreenb2cappwithintegreirteapi.data.models.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    application: Application
) : AndroidViewModel(application) {

    private val _newProducts = mutableStateOf<List<Product>>(emptyList())
    val newProducts: State<List<Product>> = _newProducts

    private val _saleProducts = mutableStateOf<List<Product>>(emptyList())
    val saleProducts: State<List<Product>> = _saleProducts

    init {
        loadNewProductsFromJson()
        loadSaleProductsFromJson()
    }

    private fun loadNewProductsFromJson() {
        try {
            val context = getApplication<Application>().applicationContext
            val jsonString = context.assets.open("NewProducts.json").bufferedReader().use { it.readText() }
            val gson = Gson()
            val type = object : TypeToken<List<Product>>() {}.type
            _newProducts.value = gson.fromJson(jsonString, type)
        } catch (e: Exception) {
            Log.e("ProductViewModel", "Error loading JSON: ${e.localizedMessage}")
        }
    }


    private fun loadSaleProductsFromJson() {
        try {
            val context = getApplication<Application>().applicationContext
            val jsonString = context.assets.open("BannerProducts.json").bufferedReader().use { it.readText() }
            val gson = Gson()
            val type = object : TypeToken<List<Product>>() {}.type
            _saleProducts.value = gson.fromJson(jsonString, type)
        } catch (e: Exception) {
            Log.e("ProductViewModel", "Error loading JSON: ${e.localizedMessage}")
        }
    }
}
