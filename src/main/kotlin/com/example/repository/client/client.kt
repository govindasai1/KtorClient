package com.example.repository.client

import com.example.models.ProductsArray
import com.google.gson.Gson
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.cache.*
import io.ktor.client.plugins.cache.storage.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.serialization.gson.*
import java.nio.file.Files
import java.nio.file.Paths

private val client = HttpClient(CIO){
    install(HttpCache){
        val storage = Files.createDirectories(Paths.get("D:\\Intllij_projects\\ktor-client\\cache")).toFile()
        publicStorage(FileStorage(storage))
    }
    install(ContentNegotiation){
        gson()
    }

}
suspend fun gettingProducts(): ProductsArray {
    val result = client.get("https://dummyjson.com/products").bodyAsText()
    return  Gson().fromJson(result, ProductsArray::class.java)
}

