package com.siri.multiscreenb2cappwithintegreirteapi.room.repo

import com.siri.multiscreenb2cappwithintegreirteapi.room.dao.ProductDao
import com.siri.multiscreenb2cappwithintegreirteapi.room.entitys.ProductEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import javax.inject.Inject


class ProductRepository @Inject constructor(private val productDao: ProductDao) {


    fun getCartProducts(): Flow<List<ProductEntity>> = productDao.getAllProducts()

    suspend fun insertProduct(product: ProductEntity) {
        productDao.insertProduct(product)
    }

    suspend fun addProduct(product: ProductEntity) {
        // เพิ่มจำนวนถ้ามีอยู่แล้ว หรือเพิ่มใหม่
        val currentProducts = productDao.getAllProducts().first()
        val existing = currentProducts.find { it.pPid == product.pPid }
        if (existing != null) {
            val updated = existing.copy(qua = existing.qua + 1)
            productDao.updateProduct(updated)
        } else {
            productDao.insertProduct(product.copy(qua = 1))
        }
    }
    suspend fun removeProduct(product: ProductEntity) {
        val currentProducts = productDao.getAllProducts().first()
        val existing = currentProducts.find { it.pPid == product.pPid }
        if (existing != null) {
            if (existing.qua > 1) {
                val updated = existing.copy(qua = existing.qua - 1)
                productDao.updateProduct(updated)
            } else {
                productDao.deleteProduct(existing)
            }
        }
    }

    suspend fun deleteProduct(product: ProductEntity) {
        productDao.deleteProduct(product)
    }
}