package com.example.table

import org.jetbrains.exposed.sql.Table

object ProductTable:Table(){
    val id = integer("id").uniqueIndex()
    val title = varchar("title",100)
    val description = varchar("description",200)
    val price = integer("price")
    val discountPercentage = double("discountPercentage")
    val rating = double("rating")
    val stock = integer("stock")
    val brand = varchar("brand",100)
    val category = varchar("category",100)
    val thumbnail =  varchar("thumbnail",250)
    val images = varchar("images",1000)
}