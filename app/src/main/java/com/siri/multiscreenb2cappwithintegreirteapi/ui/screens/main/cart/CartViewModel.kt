package com.siri.multiscreenb2cappwithintegreirteapi.ui.screens.main.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.siri.multiscreenb2cappwithintegreirteapi.room.entitys.ProductEntity
import com.siri.multiscreenb2cappwithintegreirteapi.room.repo.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val repository: ProductRepository
): ViewModel() {

    val productsInCart = repository.getCartProducts()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun add(product: ProductEntity) = viewModelScope.launch {
        repository.addProduct(product)
    }

    fun remove(product: ProductEntity) = viewModelScope.launch {
        repository.removeProduct(product)
    }

    fun delete(product: ProductEntity) = viewModelScope.launch {
        repository.deleteProduct(product)
    }

    fun checkout() {
        // ทำ logic checkout
    }
}

