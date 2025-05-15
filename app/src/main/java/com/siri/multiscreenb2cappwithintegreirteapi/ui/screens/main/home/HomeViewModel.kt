package com.siri.multiscreenb2cappwithintegreirteapi.ui.screens.main.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.siri.multiscreenb2cappwithintegreirteapi.data.DataOrException
import com.siri.multiscreenb2cappwithintegreirteapi.data.models.Banners
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    val loadBanners: MutableState<DataOrException<List<Banners>, Boolean, Exception>> =
        mutableStateOf(DataOrException(listOf(), true, Exception("")))

    private val _isLoading = mutableStateOf(false)
    val isLoading = _isLoading

    init {
        getBanners()
    }


    private fun getBanners() {
        viewModelScope.launch {

        }
    }
}