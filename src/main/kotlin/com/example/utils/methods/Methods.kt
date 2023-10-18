package com.example.utils.methods

import com.example.models.Product
import com.example.table.ProductTable
import org.jetbrains.exposed.sql.ResultRow

fun rowToProduct(row:ResultRow):Product{
    return Product(row[ProductTable.id],row[ProductTable.title],row[ProductTable.description],
        row[ProductTable.price],row[ProductTable.discountPercentage],row[ProductTable.rating],
        row[ProductTable.stock],row[ProductTable.brand],row[ProductTable.category],row[ProductTable.thumbnail],
        listOf(row[ProductTable.images]))
}