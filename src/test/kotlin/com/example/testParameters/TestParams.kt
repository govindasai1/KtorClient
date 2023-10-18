package com.example.testParameters

import com.example.models.Category
import com.example.models.Name
import com.example.models.Product

val product = Product(1, "iPhone 9", "An apple mobile which is nothing like apple",
549, 12.96, 4.69, 94, "Apple", "smartphones", "https://i.dummyjson.com/data/products/1/thumbnail.jpg",
    listOf("https://i.dummyjson.com/data/products/1/1.jpg","https://i.dummyjson.com/data/products/1/2.jpg", "https://i.dummyjson.com/data/products/1/3.jpg",
    "https://i.dummyjson.com/data/products/1/4.jpg", "https://i.dummyjson.com/data/products/1/thumbnail.jpg"))
val name = Name("mobile")
val category = Category("smartphones")
val updateProduct = Product(8, "iPhone X", "An apple mobile which is nothing like apple",
    549, 12.96, 4.69, 94, "Apple", "smartphones", "https://i.dummyjson.com/data/products/1/thumbnail.jpg",
    listOf("https://i.dummyjson.com/data/products/1/1.jpg","https://i.dummyjson.com/data/products/1/2.jpg", "https://i.dummyjson.com/data/products/1/3.jpg",
        "https://i.dummyjson.com/data/products/1/4.jpg", "https://i.dummyjson.com/data/products/1/thumbnail.jpg"))