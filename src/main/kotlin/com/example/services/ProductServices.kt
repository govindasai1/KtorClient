package com.example.services

import com.example.models.Message
import com.example.models.Product
import com.example.productsDao.ProductsDao
import com.example.repository.client.gettingProducts
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ProductServices:KoinComponent {
    private val productObj by inject<ProductsDao>()

    suspend fun insertGetAllProducts():Array<Product>{
        val products = gettingProducts().products
        val size = products.size
        for (i in 0..<size){
            productObj.insert(products[i])
        }
        return products
    }
    suspend fun searchingProduct(name:String):Array<Product>{
        return productObj.searchProduct(name)
    }

    suspend fun fetchingProducts(category:String):Array<Product>{
        return productObj.fetchProduct(category)
    }

    suspend fun deleteProduct(category: String):Message{
        return productObj.deleteProduct(category)
    }

    suspend fun updateProduct(product: Product):Message{
        return productObj.updateProduct(product)
    }

}