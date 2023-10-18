package com.example.repository.client

import com.example.models.ProductsArray
import com.google.gson.Gson
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.serialization.gson.*

private val client = HttpClient(CIO){
    install(ContentNegotiation){
        gson()
    }
}
suspend fun gettingProducts(): ProductsArray {
    val result = client.get("https://dummyjson.com/products").bodyAsText()
    return  Gson().fromJson(result, ProductsArray::class.java)
}

