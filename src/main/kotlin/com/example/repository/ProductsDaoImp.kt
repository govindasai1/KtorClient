package com.example.repository

import com.example.database.DatabaseFactory
import com.example.exception.ErrorException
import com.example.models.Message
import com.example.models.Product
import com.example.productsDao.ProductsDao
import com.example.utils.methods.rowToProduct
import com.example.table.ProductTable
import com.example.utils.responces.failureDeletion
import com.example.utils.responces.failureUpdation
import com.example.utils.responces.successDeletion
import com.example.utils.responces.successUpdation
import io.ktor.http.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.update

class ProductsDaoImp:ProductsDao {
    override suspend fun insert(products: Product):Message {
        try {
            DatabaseFactory.dbQuery {
                ProductTable.insert {
                    it[id] = products.id
                    it[title] = products.title
                    it[description] = products.description
                    it[price] = products.price
                    it[discountPercentage] = products.discountPercentage
                    it[rating] = products.rating
                    it[stock] = products.stock
                    it[brand] = products.brand
                    it[category] = products.category
                    it[thumbnail] = products.thumbnail
                    it[images] = products.images.toString()
                }
            }
            return Message("Done")
        }catch (e:Exception){
            throw ErrorException("Something Went Wrong", HttpStatusCode.InternalServerError)
        }
    }

    override suspend fun searchProduct(name: String): Array<Product> {
        val withTitle = DatabaseFactory.dbQuery { ProductTable.select { (ProductTable.title regexp name)}.map { rowToProduct(it) } }
        val withDescription = DatabaseFactory.dbQuery { ProductTable.select { (ProductTable.description regexp name) }.map { rowToProduct(it) } }
        val listToSet = (withTitle + withDescription).toSet()
        return listToSet.toTypedArray()
    }

    override suspend fun fetchProduct(category: String): Array<Product> {
        try {
        val productsList =  DatabaseFactory.dbQuery { ProductTable.select { (ProductTable.category.eq(category)) }.map { rowToProduct(it) } }
        return productsList.toTypedArray()
        }catch (e:Exception){
            throw ErrorException("Something Went Wrong", HttpStatusCode.InternalServerError)
        }
    }

    override suspend fun deleteProduct(category: String): Message {
        try{
        val result = DatabaseFactory.dbQuery { ProductTable.deleteWhere { ProductTable.category.eq(category) } }>0
        return if (result) successDeletion
        else failureDeletion
    }catch (e:Exception){
        throw ErrorException("Something Went Wrong", HttpStatusCode.InternalServerError)
    }
    }

    override suspend fun updateProduct(product: Product): Message {
        try {
            val result = DatabaseFactory.dbQuery {
                ProductTable.update({ ProductTable.id.eq(product.id) }) {
                    it[title] = product.title
                    it[description] = product.description
                    it[price] = product.price
                    it[discountPercentage] = product.discountPercentage
                    it[rating] = product.rating
                    it[stock] = product.stock
                    it[brand] = product.brand
                    it[category] = product.category
                    it[thumbnail] = product.thumbnail
                    it[images] = product.images.toString()
                } > 0
            }
            return if (result) successUpdation
            else failureUpdation
        }catch (e:Exception){
            throw ErrorException("Something Went Wrong", HttpStatusCode.InternalServerError)
        }
    }
}