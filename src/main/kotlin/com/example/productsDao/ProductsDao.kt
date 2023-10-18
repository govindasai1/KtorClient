package com.example.productsDao

import com.example.models.Message
import com.example.models.Product

interface ProductsDao {
    suspend fun insert(products:Product):Message
    suspend fun searchProduct(name:String):Array<Product>
    suspend fun fetchProduct(category:String):Array<Product>
    suspend fun deleteProduct(category:String):Message
    suspend fun updateProduct(product:Product):Message

}