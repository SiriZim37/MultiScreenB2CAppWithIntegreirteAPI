package com.siri.multiscreenb2cappwithintegreirteapi.data.models

data class Banners(
    val logo: Any? = null ,
    val brand_name: String? = null){
    fun convertToMap(): MutableMap<String,Any>{
        return mutableMapOf(
            "logo" to logo!! ,
            "brand_name" to brand_name!!
        )
    }
}