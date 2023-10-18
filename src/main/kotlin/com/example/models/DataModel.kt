package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class Product(val id:Int,val title:String,val description:String,val price:Int,
                    val discountPercentage:Double,val rating:Double,val stock:Int,
                   val brand:String,val category:String,val thumbnail:String,
                   val images:List<String>)

@Serializable
data class Message(val message: String)

@Serializable
data class ProductsArray(val products : Array<Product>)

@Serializable
data class Category(val category:String)

@Serializable
data class Name(val name:String)

